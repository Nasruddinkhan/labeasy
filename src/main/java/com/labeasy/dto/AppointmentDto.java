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
public class AppointmentDto {
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
	private Double totalAmmount;
	private Double discountAmmount;
	private String discountReason;
	private BillingAndInvoiceDto andInvoiceDto;
	private String testList;
	private String prefredLab;
	private String appointmentDate;
	private String reffredBy;
	private String assignTo;


}
