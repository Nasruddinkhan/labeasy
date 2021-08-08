package com.labeasy.services.impl;

import static com.labeasy.utils.ObjectUtilMapper.map;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.labeasy.dto.MyUserDetails;
import com.labeasy.dto.UserDto;
import com.labeasy.dto.UserRoleDto;
import com.labeasy.entity.User;

@Component
public class AuditAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		if (SecurityContextHolder.getContext().getAuthentication() != null) {
			MyUserDetails principal = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			return Optional.of(principal.getUser().getEmailId());
		}
		return Optional.empty();
	}
	

	public static UserDto getLoggedUser() {
		User details= ((MyUserDetails)  SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
		UserDto userDto = map(details, UserDto.class);
		userDto.setUserRoleDto(map(details.getUserRole(), UserRoleDto.class));
		return userDto;
	} 

}
