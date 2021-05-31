package com.labeasy.services.impl;

import static com.labeasy.utils.CommonUtils.transformTheDateFormat;
import static com.labeasy.utils.ObjectUtilMapper.map;
import static com.labeasy.utils.ObjectUtilMapper.mapAll;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.labeasy.dto.MyUserDetails;
import com.labeasy.dto.UserDto;
import com.labeasy.eception.NotFoundException;
import com.labeasy.entity.Address;
import com.labeasy.entity.User;
import com.labeasy.repsoitory.UserRepository;
import com.labeasy.services.UserService;
import com.labeasy.utils.CommonUtils;

@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImp implements UserService {
	
	private final UserRepository userRepo;
	

	@Autowired
	public UserDetailsServiceImp(final UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}
	@Override
	public void addUser(UserDto userDto) {
		User user = map(userDto, User.class);
		Address userAddress = map(userDto.getAddress(), Address.class);
		//user.setStatus(ApplicationStatus.ACTIVE.getValue());
		user.setDob(transformTheDateFormat(userDto.getDob(), DateTimeFormatter.ISO_DATE,
				(date, format) -> LocalDate.parse(date, format)));
		
		user.setDoj(transformTheDateFormat(userDto.getDoj(), DateTimeFormatter.ISO_DATE,
				(date, format) -> LocalDate.parse(date, format)));
		user.setEnabled(false);
		user.setAccountNonLocked(false);
		user.setLockTime(new Date());
		user.setActive(true);
		
		user.setNoOfFailPwdAttempt(0);
		user.setPassword(new BCryptPasswordEncoder().encode(userDto.getMobileNo())); 
		userAddress.setUser(user);
		user.setAddress(userAddress);
		
		
		 map(userRepo.save(user), UserDto.class);
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
		final List<User> usersList = userRepo.findAll();
        return mapAll(usersList, UserDto.class);
	}
	
	@Override
	public UserDto findByUserId(Long userId) {
		 final User user = findUserById(userId);
	        return map(user, UserDto.class);
	}
	
    private User findUserById(final Long userId) {
    	
    	return userRepo.findById(userId).orElseThrow(() ->
        new NotFoundException("user id not found"));	
    }

	
}
