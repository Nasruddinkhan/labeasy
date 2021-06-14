package com.labeasy.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.labeasy.dto.CountryDto;
import com.labeasy.entity.Country;
import com.labeasy.repsoitory.CountryRepository;
import com.labeasy.services.MasterService;
import static com.labeasy.utils.ObjectUtilMapper.map;
import static com.labeasy.utils.ObjectUtilMapper.mapAll;

import java.util.List;

@Service
@Transactional
public class MasterServiceImpl implements MasterService {

	private final CountryRepository coutryRepo;
	@Autowired
	public MasterServiceImpl(CountryRepository coutryRepo) {
		super();
		this.coutryRepo = coutryRepo;
	}

	@Override
	public CountryDto addCountry(CountryDto countryDto) {
		// TODO Auto-generated method stub
		Country country = map(countryDto, Country.class);
		return map(coutryRepo.save(country), CountryDto.class);
	}

	@Override
	public List<CountryDto> findAllCounties() {
		// TODO Auto-generated method stub
		return mapAll( coutryRepo.findAll(), CountryDto.class);
	}

}
