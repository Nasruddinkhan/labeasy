package com.labeasy.services;

import org.springframework.security.core.userdetails.UserDetailsService;

<<<<<<< HEAD
	void addUser(UserDto userDto);
=======
import com.labeasy.dto.UserDto;
import com.labeasy.entity.User;
>>>>>>> b9441ce8ca2205c1b5b9a3dc12d99d67e83c6184

public interface UserService extends UserDetailsService {
	
	public int increaseFailedAttempts(User user);
	public void resetFailedAttempts(String email);
	public void lock(User user);
	public boolean unlockWhenTimeExpired(User user);
	public void addUser(UserDto userDto);
	
}
