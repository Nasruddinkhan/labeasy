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
public class CountryDto {

	@JsonProperty("country_id")
	private Long countryId;

	@JsonProperty("country_name")
	private String countryName;
	
	@JsonProperty("country_code")
	private String countryCode;
}
