package com.labeasy.security;

import java.io.IOException;
import java.util.Optional;
import java.util.function.Predicate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.labeasy.entity.User;
import com.labeasy.repsoitory.UserRepository;
import com.labeasy.services.UserService;
import com.labeasy.utils.CommonUtils;

@Component
public class CustomLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	private final UserRepository userRepo;
	private final UserService userService;

	Predicate<User> isEnable = u -> u.isEnabled();
	Predicate<User> isAccountNonLocked = u -> u.isAccountNonLocked();
	Predicate<User> isFailedAttempt = u -> u.getFailedAttempt() < CommonUtils.MAX_FAILED_ATTEMPTS - 1;

	@Autowired
	public CustomLoginFailureHandler(final UserRepository userRepo, UserService userService) {
		super();
		this.userRepo = userRepo;
		this.userService = userService;
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String username = request.getParameter("username");
		Optional<User> userDetails = userRepo.findByEmailId(username);
		if (userDetails.isPresent()) {
			User user = userDetails.get();
			if (isEnable.and(isAccountNonLocked).test(user)) {
				if (isFailedAttempt.test(user)) {
					int remaining = CommonUtils.MAX_FAILED_ATTEMPTS - userService.increaseFailedAttempts(user);
					exception = new LockedException(
							exception.getMessage() + " " + remaining + " more attempts are remaining");
				} else {
					userService.lock(user);
					exception = new LockedException("Your account has been locked due to 3 failed attempts."
							+ " It will be unlocked after 24 hours.");
				}
			} else if (!isAccountNonLocked.test(user) && userService.unlockWhenTimeExpired(user) ) {
					exception = new LockedException("Your account has been unlocked. Please try to login again.");
			}
		}
		super.setDefaultFailureUrl("/login?error");
		super.onAuthenticationFailure(request, response, exception);

	}

}