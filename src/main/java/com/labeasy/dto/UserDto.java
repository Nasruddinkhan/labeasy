package com.labeasy.dto;


import java.time.LocalDateTime;
import java.util.Date;

import com.labeasy.entity.User;

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
public class UserDto  {
	

	private Long id;
	private String userId;
    private String firstName;
    private String lastName;
    private String fatherSpouseName;
    private String gender;
    private String dob;
    private String doj;
    //private String password;
    private String mobileNo;
    private String alternateMobileNo;
    private String emailId;
    private String adharCardNo;
    private String panCardNo;
    private String otherIdCardNo;
    private String remarks;
    private Long roleId;
	private AddressDto address;
    private String reportingUserId;
    private Date lastLoginDateTime;
    private String createdBy;
    private LocalDateTime createdDate;
	
	
	

   /* @JsonProperty("reg_id")
    private String regId;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("middle_name")
    private String middleName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("dob")
    private LocalDate dob;

    @JsonProperty("mobile_no")
    private String mobileNo;

    @JsonProperty("alt_mobile_no")
    private String altMobileNo;

    @JsonProperty("email_id")
    private String emailId;

    @JsonProperty("password")
    private String password;

    @JsonProperty("secret_key")
    private String secretKey;

    @JsonProperty("company_id")
    private String companyId;

    @JsonProperty("role")
    private String role;

    @JsonProperty("pan_card_no")
    private String panCardNo;

    @JsonProperty("aadhaar_card_no")
    private String aadhaarCardNo;

    @JsonProperty("status")
    private String status;

    @JsonProperty("is_smartphone")
    private Boolean isSmartPhone;
*/
}
