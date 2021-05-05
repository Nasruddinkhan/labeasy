package com.labeasy.dto;

import static com.labeasy.constant.MessageConstants.EMAIL_EMPTY_VLD;
import static com.labeasy.constant.MessageConstants.MOB_NO_EMPTY_VLD;
import static com.labeasy.constant.MessageConstants.NAME_EMPTY_VLD;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Nasruddin
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class InquiryDto {
    @JsonProperty("inq_id")
    private Long inqId;
    @NotBlank(message =NAME_EMPTY_VLD)
    @JsonProperty("name")
    private String name;
    @NotBlank(message = MOB_NO_EMPTY_VLD)
    @JsonProperty("mobile_no")
    private String mobileNo;
    @NotBlank(message = EMAIL_EMPTY_VLD)
    @JsonProperty("email_id")
    private String emailId;
    @JsonProperty("status")
    private String status;
    @JsonProperty("company_Id")
    private Long companyId;

}
