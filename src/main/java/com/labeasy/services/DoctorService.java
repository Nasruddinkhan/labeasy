package com.labeasy.services;

import java.util.List;

import com.labeasy.dto.DoctorDto;


public interface DoctorService {
	public DoctorDto addNewDoctor(DoctorDto doctorDto);
	public List<DoctorDto> findAllDoctors();
	public DoctorDto findById(Long id);

}
