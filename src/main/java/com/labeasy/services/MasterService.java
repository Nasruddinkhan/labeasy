package com.labeasy.services;

import java.util.List;

import com.labeasy.dto.CityDto;
import com.labeasy.dto.CountryDto;
import com.labeasy.dto.PinCodeDto;
import com.labeasy.dto.StateDto;
import com.labeasy.entity.Country;

public interface MasterService {

	CountryDto addCountry(CountryDto countryDto);

	StateDto addState(StateDto stateDto);

	List<CountryDto> findAllCounties();

	List<StateDto> findAllStates();

	List<CityDto> findAllCities();

	List<PinCodeDto> findAllPinCode();

	Country findByCountryName(String name);

	List<StateDto> showStateByCountry(Long id);

	List<CityDto> showCityByState(Long id);

	CityDto addCity(CityDto cityDto);

	PinCodeDto addPinCode(PinCodeDto pinCodeDto);

}
