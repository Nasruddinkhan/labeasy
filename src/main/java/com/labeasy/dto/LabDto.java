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
public class LabDto {
	@JsonProperty("lab_id")
	private Long id;
	@JsonProperty("lab_code")
	private String lab_code;
	@JsonProperty("name")
	private String name;
	@JsonProperty("reg_num")
	private String Registration_no;
	@JsonProperty("contact")
	private String contact;
	@JsonProperty("alt_contact")
	private String alt_number;
	@JsonProperty("email")
	private String email;
	@JsonProperty("alt_email")
	private String alt_email;
	@JsonProperty("address")
	private String address;
	@JsonProperty("city_id")
	private String city;
	@JsonProperty("pincode")
	private String pincode;
	@JsonProperty("state_id")
	private String state;
	@JsonProperty("manage_by")
	private String managed_by;
	@JsonProperty("website")
	private String website;
	@JsonProperty("remark")
	private String remark;

	private StateDto stateDto;
	private CityDto cityDto;
}
