package com.labeasy.services;

import java.util.List;

import com.labeasy.dto.B2BRegistrationDto;
import com.labeasy.entity.B2BRegistration;

public interface B2BRegistrationService {
	
	B2BRegistrationDto addB2BRegistation(B2BRegistrationDto b2bRegDto);

	List<B2BRegistrationDto> findAllB2BRegistations();

	B2BRegistrationDto findByLabId(Long id);
}
