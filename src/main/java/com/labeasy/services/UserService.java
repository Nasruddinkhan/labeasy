package com.labeasy.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.labeasy.dto.DropDownDto;
import com.labeasy.dto.UserDto;
import com.labeasy.entity.User;

public interface UserService extends UserDetailsService {
	
	public int increaseFailedAttempts(User user);
	public void resetFailedAttempts(String email);
	public void lock(User user);
	public boolean unlockWhenTimeExpired(User user);
	public UserDto addUser(UserDto userDto);
	public List<UserDto> getAllUserList() ;
	public UserDto findByUserId(Long userId);
	public List<DropDownDto> getAllPhlebotomistList() ;
	
}
