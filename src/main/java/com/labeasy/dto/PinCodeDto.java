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
public class PinCodeDto {

	@JsonProperty("pin_id")
	private Long pinId;
	@JsonProperty("pin_code")
	private String pinCode;
	@JsonProperty("area_name")
	private String areaName;
	@JsonProperty("city_id")
	private Long cityId;

	private CityDto cityDto;
}
