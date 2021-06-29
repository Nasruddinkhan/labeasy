package com.labeasy.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "doctors")
public class Doctor extends BaseBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8590733541572855079L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctorseq")
	@SequenceGenerator(name = "doctorseq", sequenceName = "doctor_seq", allocationSize = 1, initialValue = 1)
	private Long id;
	@Column(name = "prefix", length = 20)
	private String prefix;
	@Column(name = "name", length = 50)
	private String name;
	@Column(name = "speciality", length = 20)
	private String speciality;
	@Column(name = "registration_id")
	private String registrationId;
	@Column(name = "mobile_no", length = 15)
	private String mobileNo;
	@Column(name = "alternate_mobile_no", length = 15)
	private String alternateMobileNo;
	@Column(name = "email", length = 50)
	private String emailId;
	@Column(name = "alternateemail", length = 50)
	private String alternateEmailId;
	@Column(name = "address")
	private String address;
	@Column(name = "city")
	private String city;
	@Column(name = "pincode")
	private String pincode;
	@Column(name = "state")
	private String state;
	@Column(name = "incentice_percentage")
	private Double incenticePercentage;
	@Column(name = "managed_by")
	private String managedBy;
	@Column(name = "web_site")
	private String webSite;
	@Column(name = "remarks")
	private String remarks;

}
