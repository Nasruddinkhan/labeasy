package com.labeasy.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.labeasy.dto.MyUserDetails;
import com.labeasy.eception.NotFoundException;
import com.labeasy.entity.User;
import com.labeasy.repsoitory.UserRepository;
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
}
