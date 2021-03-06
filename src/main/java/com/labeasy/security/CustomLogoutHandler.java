package com.labeasy.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;
@Component
public class CustomLogoutHandler implements LogoutHandler {
	

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		System.out.println(authentication.getName());
		System.out.println("CustomLogoutHandler.logout()");
	}

}
