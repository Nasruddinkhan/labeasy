package com.labeasy.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "billing")
public class BillingAndInvoice  extends BaseBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7845756231923388839L;
	@Id
	@Column(name = "billing_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "billing_seq")
	@SequenceGenerator(name = "billing_seq", sequenceName = "billing_seq", allocationSize = 1, initialValue = 1)
	private Long billingId;
	@Column(name = "payment_ammount")
	private Double paymentAmmount;
	@Column(name = "payment_mode", length = 15)
	private String paymentMode;
	@Column(name = "advance_payment")
	private Double advancePayment;
	@Column(name = "total_ammount")
	private Double totalAmmount;
	@Column(name = "payment_date")
	private LocalDateTime paymentDate;
    @JoinColumn(name =  "appointment_id")
	@ManyToOne(fetch = FetchType.EAGER)
    private Appointment appointment;
}
