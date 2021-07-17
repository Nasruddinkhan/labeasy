package com.labeasy.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

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
public final  class AppointmentDto {
	private Long appointmentId;
	private String name;
	private String contactNo;
	private String alternateContactNo;
	private String emailId;
	private String appStatus;
	private String remarks;
	private Integer age;
	private String gender;
	private String region;
	private String cityId;
	private BillingAndInvoiceDto addInvoiceDto;
	private Set<BillingAndInvoiceDto> addInvoices ;
	private String testList;
	private String preferredLab;
	private String appointmentDate;
	private LocalTime appointmentTime;
	private String referredBy;
	private Long assignTo;
	private UserDto assignToUserDto;
	private String addressLine1;  
	private String addressLine2;
    private String createdBy;
    private LocalDateTime createdDate;
    private Set<TestNamesDto> testNames;
    private String visitType;
	private String isWhatsappActive;
	private String isEmailStatus;
	private String pinCode;


}
