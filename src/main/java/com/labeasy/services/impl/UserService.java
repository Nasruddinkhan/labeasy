package com.labeasy.services.impl;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.labeasy.entity.User;

public interface UserService extends UserDetailsService {
	
	public int increaseFailedAttempts(User user);
	public void resetFailedAttempts(String email);
	public void lock(User user);
	public boolean unlockWhenTimeExpired(User user);
	
}
