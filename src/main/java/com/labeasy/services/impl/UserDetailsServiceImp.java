package com.labeasy.services.impl;

import static com.labeasy.utils.CommonUtils.transformTheDateFormat;
import static com.labeasy.utils.ObjectUtilMapper.map;
import static com.labeasy.utils.ObjectUtilMapper.mapAll;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.labeasy.dto.DropDownDto;
import com.labeasy.dto.MyUserDetails;
import com.labeasy.dto.UserDto;
import com.labeasy.dto.UserRoleDto;
import com.labeasy.eception.NotFoundException;
import com.labeasy.entity.Address;
import com.labeasy.entity.Appointment;
import com.labeasy.entity.User;
import com.labeasy.entity.UserRole;
import com.labeasy.enums.AppointmentStatus;
import com.labeasy.enums.RoleEnum;
import com.labeasy.repsoitory.UserRepository;
import com.labeasy.repsoitory.UserRoleRepository;
import com.labeasy.services.UserService;
import com.labeasy.utils.CommonUtils;

@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImp implements UserService {

	private final UserRepository userRepo;
	private final UserRoleRepository repository;
	static Predicate<String> isApplicationStatus = (
			status) -> AppointmentStatus.NEWLY_CREATED_APPOINTMENT.getValue().equals(status)
					|| AppointmentStatus.ASSIGNED_TO_PHLEBO.getValue().equals(status)
					|| AppointmentStatus.SAMPLE_COLLECTED.getValue().equals(status)
					|| AppointmentStatus.CUSTOMER_TRACK.getValue().equals(status);

	@Autowired
	public UserDetailsServiceImp(final UserRepository userRepo, final UserRoleRepository repository) {
		super();
		this.userRepo = userRepo;
		this.repository = repository;

	}

	@Override
	public UserDto addUser(UserDto userDto) {
		User user = map(userDto, User.class);
		Address userAddress = map(userDto.getAddress(), Address.class);
		user.setDob(transformTheDateFormat(userDto.getDob(), DateTimeFormatter.ISO_DATE,
				(date, format) -> LocalDate.parse(date, format)));
		user.setDoj(transformTheDateFormat(userDto.getDoj(), DateTimeFormatter.ISO_DATE,
				(date, format) -> LocalDate.parse(date, format)));
		user.setEnabled(true);
		user.setAccountNonLocked(true);
		user.setLockTime(new Date());
		user.setActive(true);
		user.setNoOfFailPwdAttempt(0);
		user.setPassword(new BCryptPasswordEncoder().encode(userDto.getMobileNo()));
		userAddress.setUser(user);
		user.setAddress(userAddress);
		user.setUserRole(getUserRole(userDto.getRoleId()));
		if (Objects.nonNull(userDto.getReportingUserId()))
			user.setReportingUser(findUserById(userDto.getReportingUserId()));
		return map(userRepo.save(user), UserDto.class);

	}

	private UserRole getUserRole(Long roleId) {
		// TODO Auto-generated method stub
		return repository.findById(roleId).orElseThrow(() -> new NotFoundException("ROle not found"));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepo.findByEmailId(username).map(MyUserDetails::new)
				.orElseThrow(() -> new NotFoundException(username + " :: is not found"));
	}

	@Override
	public int increaseFailedAttempts(User user) {
		int newFailAttempts = user.getFailedAttempt() + 1;
		userRepo.updateFailedAttempts(newFailAttempts, user.getEmailId());
		return newFailAttempts;
	}

	@Override
	public void resetFailedAttempts(String email) {
		userRepo.updateFailedAttempts(0, email);
	}

	@Override
	public void lock(User user) {
		user.setAccountNonLocked(false);
		user.setLockTime(new Date());
		userRepo.save(user);
	}

	@Override
	public boolean unlockWhenTimeExpired(User user) {
		long lockTimeInMillis = user.getLockTime().getTime();
		long currentTimeInMillis = System.currentTimeMillis();
		if (lockTimeInMillis + CommonUtils.LOCK_TIME_DURATION < currentTimeInMillis) {
			user.setAccountNonLocked(true);
			user.setLockTime(null);
			user.setFailedAttempt(0);
			userRepo.save(user);
			return true;
		}
		return false;
	}

	@Override
	public List<UserDto> getAllUserList() {
		return userRepo.findAll().stream().map(UserDetailsServiceImp::toUserDto).collect(Collectors.toList());
	}

	public static UserDto toUserDto(User user) {
		UserDto dto = map(user, UserDto.class);
		if (Objects.nonNull(user.getUserRole())) {
			dto.setUserRoleDto(map(user.getUserRole(), UserRoleDto.class));
			dto.setRoleId(user.getUserRole().getRoleId());
		}
		if(Objects.nonNull(user.getReportingUser())) {
			dto.setReportingUser(map(user.getReportingUser(), UserDto.class));
			dto.setReportingUserId(user.getReportingUser().getId());
			//dto.setSubordinates(mapAll(user.getSubordinates(), UserDto.class));
		}
		return dto;
	}

	@Override
	public UserDto findByUserId(Long userId) {
		final User user = findUserById(userId);
		return toUserDto(user);
	}

	private User findUserById(final Long userId) {
		return userRepo.findById(userId).orElseThrow(() -> new NotFoundException("user id not found"));
	}

	@Override
	public List<DropDownDto> getAllPhlebotomistList() {
		UserRole userRole = repository.findByRoleName(RoleEnum.PHLEBOTOMIST.getValue());
		return mapAll(userRepo.findByUserRole(userRole), User.class).stream()
				.map(UserDetailsServiceImp::transformPhlebo).collect(Collectors.toList());
	}

	public static DropDownDto transformPhlebo(User user) {
		String name = user.getFirstName() + " " + user.getLastName();
		if (Objects.nonNull(user.getAppointment())) {
			int count = user.getAppointment().stream().map(Appointment::getAppStatus).filter(isApplicationStatus::test)
					.collect(Collectors.toList()).size();
			name = name + " - " + count;
		}
		return new DropDownDto(String.valueOf(user.getId()), name);
	}

}
