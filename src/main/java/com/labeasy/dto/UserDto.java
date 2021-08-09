package com.labeasy.dto;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

	private Long id;
	private String userId;
	private String firstName;
	private String lastName;
	private String fatherSpouseName;
	private String gender;
	private String dob;
	private String doj;
	private String mobileNo;
	private String alternateMobileNo;
	private String emailId;
	private String adharCardNo;
	private String panCardNo;
	private String otherIdCardNo;
	private String remarks;
	private Long roleId;
	private AddressDto address;
	private Long reportingUserId;
	private Date lastLoginDateTime;
	private String createdBy;
	private LocalDateTime createdDate;
	private UserRoleDto userRoleDto;
	//private Set<UserDto> subordinates; 
	private UserDto reportingUser;
	private String password;
	private String rePassword;
}
