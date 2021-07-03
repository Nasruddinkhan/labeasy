package com.labeasy.services.impl;

import static com.labeasy.utils.ObjectUtilMapper.map;
import static com.labeasy.utils.ObjectUtilMapper.mapAll;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.labeasy.dto.CityDto;
import com.labeasy.dto.CountryDto;
import com.labeasy.dto.PinCodeDto;
import com.labeasy.dto.StateDto;
import com.labeasy.entity.City;
import com.labeasy.entity.Country;
import com.labeasy.entity.PinCode;
import com.labeasy.entity.State;
import com.labeasy.repsoitory.CityRepository;
import com.labeasy.repsoitory.CountryRepository;
import com.labeasy.repsoitory.PinCodeRepository;
import com.labeasy.repsoitory.StateRepository;
import com.labeasy.services.MasterService;

@Service
@Transactional
public class MasterServiceImpl implements MasterService {

	private final CountryRepository coutryRepo;
	private final StateRepository stateRepo;
	private final CityRepository cityRepo;
	private final PinCodeRepository pinCodeRepo;

	@Autowired
	public MasterServiceImpl(CountryRepository coutryRepo, StateRepository stateRepo, CityRepository cityRepo,
			PinCodeRepository pinCodeRepo) {
		this.coutryRepo = coutryRepo;
		this.stateRepo = stateRepo;
		this.cityRepo = cityRepo;
		this.pinCodeRepo = pinCodeRepo;
	}

	@Override
	public CountryDto addCountry(CountryDto countryDto) {
		Country country = map(countryDto, Country.class);
		return map(coutryRepo.save(country), CountryDto.class);
	}

	@Override
	public List<CountryDto> findAllCounties() {
		return mapAll(coutryRepo.findAll(), CountryDto.class);
	}

	@Override
	public StateDto addState(StateDto stateDto) {

		State state = map(stateDto, State.class);
		state.setCountry(coutryRepo.findById(stateDto.getCountryId()).get());
		return map(stateRepo.save(state), StateDto.class);
	}

	@Override
	public List<StateDto> findAllStates() {
		return stateRepo.findAll().stream().map(stateObj::apply).collect(Collectors.toList());
	}

	Function<State, StateDto> stateObj = (state) -> {
		CountryDto countryDto = map(state.getCountry(), CountryDto.class);
		StateDto stateDto = map(state, StateDto.class);
		stateDto.setCountryDto(countryDto);
		return stateDto;
	};

	@Override
	public Country findByCountryName(String name) {

		return coutryRepo.findByCountryName(name);
	}

	@Override
	public List<StateDto> showStateByCountry(Long id) {
		return mapAll(stateRepo.findByCountry(coutryRepo.findById(id).get()), StateDto.class);
	}

	@Override
	public CityDto addCity(CityDto cityDto) {
		City city = map(cityDto, City.class);
		city.setState(stateRepo.findById(cityDto.getStateId()).get());
		return map(cityRepo.save(city), CityDto.class);

	}

	@Override
	public List<CityDto> findAllCities() {
		return cityRepo.findAll().stream().map(cityObj::apply)
				.collect(Collectors.toList());
	}

	Function<City, CityDto> cityObj = (city) -> {
		StateDto stateDto = map(city.getState(), StateDto.class);
		CityDto cityDto = map(city, CityDto.class);
		cityDto.setStateDto(stateDto);
		cityDto.setCountryDto( map(city.getState().getCountry(), CountryDto.class));
		return cityDto;
	};

	@Override
	public List<CityDto> showCityByState(Long id) {
		return mapAll(cityRepo.findByState(stateRepo.findById(id).get()), CityDto.class);
	}

	@Override
	public PinCodeDto addPinCode(PinCodeDto pinCodeDto) {
		PinCode pinCode = map(pinCodeDto, PinCode.class);
		pinCode.setCity(cityRepo.findById(pinCodeDto.getCityId()).get());
		return map(pinCodeRepo.save(pinCode), PinCodeDto.class);

	}

	@Override
	public List<PinCodeDto> findAllPinCode() {
		return pinCodeRepo.findAll().stream().map(pin::apply).collect(Collectors.toList());
	}

	Function<PinCode, PinCodeDto> pin = (pin) -> {
		CityDto cityDto = map(pin.getCity(), CityDto.class);
		PinCodeDto pinCodeDto = map(pin, PinCodeDto.class);
		pinCodeDto.setCityDto(cityDto);
		return pinCodeDto;
	};

	
}
