package com.labeasy.services;

import java.util.List;

import com.labeasy.dto.CountryDto;

public interface MasterService {

	CountryDto addCountry(CountryDto countryDto);
	List<CountryDto> findAllCounties();

}
