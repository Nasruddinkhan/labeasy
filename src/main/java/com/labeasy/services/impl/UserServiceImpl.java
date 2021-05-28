package com.labeasy.services.impl;

import static com.labeasy.utils.ObjectUtilMapper.map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.labeasy.dto.UserDto;
import com.labeasy.entity.Address;
import com.labeasy.entity.User;
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
	public UserDto addUser(UserDto userDto) {
		User user = map(userDto, User.class);
		Address userAddress = map(userDto.getAddress(), Address.class);
		//user.setStatus(ApplicationStatus.ACTIVE.getValue());
		user.setNoOfFailPwdAttempt(0);
		user.setPassword("$2a$10$MW32GAFhFjaHZZLnBKreje.o87qUjOJ8rGwveRQuJlMRl5mAvoj2C");
		
		userAddress.setUser(user);
		user.setAddress(userAddress);
		
		
		return map(userRepository.save(user), UserDto.class);
	}


}
