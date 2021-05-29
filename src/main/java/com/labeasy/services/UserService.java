package com.labeasy.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.labeasy.dto.UserDto;
import com.labeasy.entity.User;

public interface UserService extends UserDetailsService {
	
	public int increaseFailedAttempts(User user);
	public void resetFailedAttempts(String email);
	public void lock(User user);
	public boolean unlockWhenTimeExpired(User user);
	public void addUser(UserDto userDto);
	
}
