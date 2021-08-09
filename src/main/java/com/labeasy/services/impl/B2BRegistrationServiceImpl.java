package com.labeasy.services.impl;

import static com.labeasy.utils.ObjectUtilMapper.map;
import static com.labeasy.utils.ObjectUtilMapper.mapAll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labeasy.dto.B2BRegistrationDto;
import com.labeasy.eception.NotFoundException;
import com.labeasy.entity.B2BRegistration;
import com.labeasy.enums.ApplicationStatus;
import com.labeasy.repsoitory.B2BRegistrationRepository;
import com.labeasy.services.B2BRegistrationService;

@Service
public class B2BRegistrationServiceImpl implements B2BRegistrationService{

	private final B2BRegistrationRepository b2bRegRepo;
	
	@Autowired
	public B2BRegistrationServiceImpl(final B2BRegistrationRepository b2bRegRepo) {
		super();
		this.b2bRegRepo = b2bRegRepo;

	}
	
	@Override
	public B2BRegistrationDto addB2BRegistation(B2BRegistrationDto b2bRegDto) {
		B2BRegistration b2bReg = map(b2bRegDto, B2BRegistration.class);
		b2bReg.setStatus(ApplicationStatus.ACTIVE.getValue());
		return map(b2bRegRepo.save(b2bReg), B2BRegistrationDto.class);
	}

	@Override
	public List<B2BRegistrationDto> findAllB2BRegistations() {
		final List<B2BRegistration> b2bRegs = b2bRegRepo.findByStatus(ApplicationStatus.ACTIVE.getValue());
        return mapAll(b2bRegs, B2BRegistrationDto.class);
	}

	@Override
	public B2BRegistrationDto findByLabId(Long id) {
		System.out.println("B2BRegistrationServiceImpl.findByLabId=======================");
		return map(findById(id), B2BRegistrationDto.class);
	}
	
	private B2BRegistration findById(final Long id) {
		return b2bRegRepo.findById(id).orElseThrow(() -> new NotFoundException("id not found"));
		
	}

}
