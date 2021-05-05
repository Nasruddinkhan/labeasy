package com.labeasy.dto;


import lombok.*;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author : Nasruddin khan
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto  {

    @JsonProperty("reg_id")
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

}
