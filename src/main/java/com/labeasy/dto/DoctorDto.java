package com.labeasy.dto;

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
public class DoctorDto {
	private Long id;
	private String prefix;
	private String name;
	private String speciality;
	private String registrationId;
	private String mobileNo;
	private String alternateMobileNo;
	private String emailId;
	private String alternateEmailId;
	private String address;
	private String city;
	private String pincode;
	private String state;
	private Double incenticePercentage;
	private String managedBy;
	private String webSite;
	private String remarks;

}
