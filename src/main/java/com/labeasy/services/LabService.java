package com.labeasy.services;

import java.util.List;

import com.labeasy.dto.LabDto;
import com.labeasy.entity.Lab;

public interface LabService {
	LabDto addLab(LabDto labDto);

	List<LabDto> findAllLab();

	Lab findByLab(String lab_id);
}
