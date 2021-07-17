package com.labeasy.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "appointment")
public class Appointment extends BaseBean implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 7014542324125908780L;
	@Id
	@Column(name = "appointment_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_seq")
	@SequenceGenerator(name = "appointment_seq", sequenceName = "appointment_seq", allocationSize = 1, initialValue = 100)
	private Long appointmentId;
	@Column(name = "name", length = 50)
	private String name;
	@Column(name = "address_line_1", length = 100) 
	private String addressLine1;
	@Column(name = "address_line_2", length = 100)
	private String addressLine2;
	@Column(name = "contact_no", length = 15) 
	private String contactNo;
	@Column(name = "alternate_contact_no", length = 15) 
	private String alternateContactNo;
	@Column(name = "email_id", length = 60)
	private String emailId;
	@Column(name = "status", columnDefinition = "char(2) ")
	private String appStatus;
	@Column(name = "remarks")
	private String remarks;
	@Column(name = "gender", columnDefinition = "char(1)")
	private String gender;
	@Column(name = "age")
	private Integer age;
	@Column(name = "region")
	private String region;
	@Column(name = "city_id")
	private String cityId;
	@Column(name = "preferred_lab", length = 100)
	private String preferredLab;
	@Column(name = "appointment_date")
	private LocalDate appointmentDate;
	@Column(name = "appointment_time")
	private LocalTime appointmentTime;
	@Column(name = "referred_by", length = 100)
	private String referredBy;
	
	@Column(name = "is_active", columnDefinition = "boolean default true")
	private boolean isActive;
	@Column(name = "visit_type", columnDefinition = "char(1) default 'N'")
	private String visitType;
	@ManyToMany
	@JoinTable(name = "appointment_test_mapping", joinColumns = {
			@JoinColumn(name = "appointment_id") }, inverseJoinColumns = { @JoinColumn(name = "test_id") })
	private Set<TestNames> testNames = null;

	@OneToMany(mappedBy = "appointment", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
	private Set<BillingAndInvoice> billingAndInvoices;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "assign_to", referencedColumnName ="id", nullable = true)
	private User assign = null;
	@Column(name = "email_status", columnDefinition = "char(1) default 'N'")
	private String isEmailStatus;
	@Column(name = "isInvoice_status", columnDefinition = "char(1) default 'N'")
	private String invoiceStatus;
	@Column(name = "phelebo_email_status", columnDefinition = "char(1) default 'N'")
	private String pheleboEmail;
	@Column(name = "is_whatsapp_active", length = 5)
	private String isWhatsappActive;
	@Column(name = "pin_code ")
	private String pinCode;

}
