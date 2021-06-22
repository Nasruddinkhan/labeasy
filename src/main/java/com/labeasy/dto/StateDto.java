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
public class StateDto {

	@JsonProperty("state_id")
	private Long stateId;

	@JsonProperty("state_name")
	private String stateName;

	@JsonProperty("state_code")
	private String stateCode;

	@JsonProperty("countryId")
	private Long countryId;
	
	private CountryDto countryDto;
}
