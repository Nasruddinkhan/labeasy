package com.labeasy.services.impl;

import static com.labeasy.utils.ObjectUtilMapper.map;
import static com.labeasy.utils.ObjectUtilMapper.mapAll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.labeasy.dto.DoctorDto;
import com.labeasy.eception.NotFoundException;
import com.labeasy.entity.Doctor;
import com.labeasy.repsoitory.DoctorRepository;
import com.labeasy.services.DoctorService;;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {
	private final DoctorRepository doctorRepository;

	@Autowired
	public DoctorServiceImpl(DoctorRepository doctorRepository) {
		super();
		this.doctorRepository = doctorRepository;
	}

	public DoctorDto addNewDoctor(DoctorDto doctorDto) {
		Doctor doctor = map(doctorDto, Doctor.class);
		return map(doctorRepository.save(doctor), DoctorDto.class);
	}

	@Override
	public List<DoctorDto> findAllDoctors() {

		return mapAll(doctorRepository.findAll(), DoctorDto.class);
	}

	@Override
	public DoctorDto findById(Long id) {
		
		return map(doctorRepository.findById(id).orElseThrow(()->new NotFoundException("Object Not found")), DoctorDto.class);
	}

}
