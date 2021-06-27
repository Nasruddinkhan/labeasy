package com.labeasy.event;

import org.springframework.context.ApplicationEvent;

import com.labeasy.dto.AppointmentDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentConfirmationEvent extends ApplicationEvent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6857242080304805007L;
	private AppointmentDto dto;

	public AppointmentConfirmationEvent(AppointmentDto dto) {
		super(dto);
		this.dto = dto;
	}
}
