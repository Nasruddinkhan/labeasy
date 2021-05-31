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
	private String mobileNo;
	private String emailId;
	private String status;
	private String remarks;
	private Integer age;
	private String gender;
	private String address;
	private String cityId;
	private BillingAndInvoiceDto andInvoiceDto;
	private Set<BillingAndInvoiceDto> andInvoices ;
	private String testList;
	private String prefredLab;
	private String appointmentDate;
	private LocalTime appointmentTime;
	private String reffredBy;
	private String assignTo;
	private String roomNoBldNo;
	private String areLocStreetName;
    private String createdBy;
    private LocalDateTime createdDate;
 
}
