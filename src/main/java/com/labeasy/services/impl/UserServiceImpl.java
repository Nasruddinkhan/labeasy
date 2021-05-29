package com.labeasy.services.impl;

import static com.labeasy.utils.ObjectUtilMapper.map;

import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.labeasy.dto.UserDto;
import com.labeasy.entity.Address;
import com.labeasy.entity.User;
import com.labeasy.enums.ApplicationStatus;
import com.labeasy.repsoitory.UserRepository;
import com.labeasy.services.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(final UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public void addUser(UserDto userDto) {
		User user = map(userDto, User.class);
		Address userAddress = map(userDto.getAddress(), Address.class);
		user.setStatus(ApplicationStatus.ACTIVE.getValue());
		user.setEnabled(false);
		user.setAccountNonLocked(false);
		user.setFailedAttempt(0);
		
		// Generate one time password and send it on email		
		// Call here to generate one time password generateAlphaNumRandomPassword()
		user.setPassword(new BCryptPasswordEncoder().encode(generateAlphaNumRandomPassword())); 
		userAddress.setUser(user);
		user.setReportingUser(user);
		user.setAddress(userAddress);
		map(userRepository.save(user), UserDto.class);
	}
	
	
	private String generateAlphaNumRandomPassword() {
        String password = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        password="test";
        return password;
    }


}
