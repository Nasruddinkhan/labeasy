package com.labeasy.event;

import org.springframework.context.ApplicationEvent;

import com.labeasy.dto.UserDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OnUserRegistrationCompleteEvent extends ApplicationEvent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6857242080304805007L;
	private UserDto dto;

	public OnUserRegistrationCompleteEvent(UserDto dto) {
		super(dto);
		this.dto = dto;
	}
}
