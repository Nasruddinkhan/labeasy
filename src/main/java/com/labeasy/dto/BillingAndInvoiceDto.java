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
public class BillingAndInvoiceDto {
	private Long billingId;
	private Double paymentAmmount;
	private String paymentMode;
	private Double advancePayment;
	private Double totalAmmount;
	private LocalDateTime paymentDate;
	private Double discountAmmount;
	private String discountReason;
}
