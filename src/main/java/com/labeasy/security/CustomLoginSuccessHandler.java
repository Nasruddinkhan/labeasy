package com.labeasy.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.labeasy.dto.MyUserDetails;
import com.labeasy.entity.User;
import com.labeasy.services.UserService;

@Component
public class CustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private final UserService userService;
	@Autowired
	public CustomLoginSuccessHandler( UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
		User user = userDetails.getUser();
		if (user.getFailedAttempt() > 0) {
			userService.resetFailedAttempts(user.getEmailId());
		}
		super.onAuthenticationSuccess(request, response, authentication);
	}
}