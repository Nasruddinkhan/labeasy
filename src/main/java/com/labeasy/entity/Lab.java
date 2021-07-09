package com.labeasy.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

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
@Table(name = "labs")

public class Lab extends BaseBean implements Serializable {
	private static final long serialVersionUID = -5648186543211073082L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "labseq")
	@SequenceGenerator(name = "labseq", sequenceName = "lab_seq", allocationSize = 1, initialValue = 1)
	private Long id;
	@Column(name = "lab_code")
	private String lab_code;
	@Column(name = "name")
	private String name;
	@Column(name = "registration_no")
	private String Registration_no;
	@Column(name = "contact")
	private String contact;
	@Column(name = "alt_number")
	private String alt_number;
	@Column(name = "email")
	private String email;
	@Column(name = "alt_email")
	private String alt_email;
	@Column(name = "address")
	private String address;
	@Column(name = "city")
	private String city;
	@Column(name = "pincode")
	private String pincode;
	@Column(name = "state")
	private String state;
	@Column(name = "managed_by")
	private String managed_by;
	@Column(name = "website")
	private String website;
	@Column(name = "remark")
	private String remark;
}
