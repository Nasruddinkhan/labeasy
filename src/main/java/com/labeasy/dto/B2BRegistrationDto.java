package com.labeasy.dto;

import java.time.LocalDateTime;

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
public class B2BRegistrationDto {
	private Long id;
	private String regType;
	private String code;
	private String name;
	private String regNum;
	private String idCardNo;
	private String otherIdCardNo;
	private String contactNo;
	private String alternateContactNo;
	private String email;
	private String alternateEmail;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String pinCode;
	private String state;
	private String country;
	private String website;
	private String remarks;
	private String updatedBy;
    private LocalDateTime updatedDate;
}
