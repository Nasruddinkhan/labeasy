package com.labeasy.services.impl;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.labeasy.dto.MyUserDetails;

@Component
public class AuditAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		// TODO Auto-generated method stub
		if (SecurityContextHolder.getContext().getAuthentication() != null) {
			MyUserDetails principal = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			return Optional.of(principal.getUser().getEmailId());
		}
		return Optional.empty();
	}

}
