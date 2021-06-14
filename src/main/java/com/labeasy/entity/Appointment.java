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
public class Appointment extends BaseBean<String> implements Serializable {

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
	@Column(name = "room_no_bldg_name", length = 50)
	private String roomNoBldNo;
	@Column(name = "area_locality_street_name", length = 50)
	private String areLocStreetName;
	@Column(name = "mobile_no", length = 10)
	private String mobileNo;
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
	@Column(name = "address ")
	private String address;
	@Column(name = "city_id")
	private String cityId;
	@Column(name = "prefred_lab", length = 100)
	private String prefredLab;
	@Column(name = "appointment_date")
	private LocalDate appointmentDate;
	@Column(name = "appointment_time")
	private LocalTime appointmentTime;
	@Column(name = "reffred_by", length = 100)
	private String reffredBy;
	@Column(name = "assign_to", length = 100)
	private String assignTo;
	@Column(name = "is_active", columnDefinition = "boolean default true")
	private boolean isActive;
	@Column(name = "customer_visited", columnDefinition = "char(1) default 'N'")
	private String customerVisited;
	@ManyToMany
	@JoinTable(name = "appointment_test_mapping", joinColumns = {
			@JoinColumn(name = "appointment_id") }, inverseJoinColumns = { @JoinColumn(name = "test_id") })
	private Set<TestNames> testNames = null;

	@OneToMany(mappedBy = "appointment", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
	private Set<BillingAndInvoice> billingAndInvoices;

}
