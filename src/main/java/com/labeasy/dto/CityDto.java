package com.labeasy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CityDto {

	@JsonProperty("city_id")
	private Long cityId;

	@JsonProperty("city_name")
	private String cityName;

	@JsonProperty("state_id")
	private Long stateId;
	
	private StateDto stateDto;
	
	private CountryDto countryDto;
}
