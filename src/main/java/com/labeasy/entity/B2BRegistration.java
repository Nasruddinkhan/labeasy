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
@Table(name = "b2b_registrations")

public class B2BRegistration extends BaseBean implements Serializable {
	private static final long serialVersionUID = -5648186543211073082L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "b2bregseq")
	@SequenceGenerator(name = "b2bregseq", sequenceName = "b2b_reg_seq", allocationSize = 1, initialValue = 1)
	private Long id;
	@Column(name = "reg_ype")
	private String regType;
	@Column(name = "code")
	private String code;
	private String name;
	@Column(name = "registration_num")
	private String regNum;
	@Column(name = "id_card_no")
	private String idCardNo;
	@Column(name = "othe_id_card_no")
	private String otherIdCardNo;
	@Column(name = "contact_no")
	private String contactNo;
	@Column(name = "alternate_contact_no")
	private String alternateContactNo;
	@Column(name = "email")
	private String email;
	@Column(name = "alternate_email")
	private String alternateEmail;
	@Column(name = "address_line_1")
	private String addressLine1;
	@Column(name = "address_line_2")
	private String addressLine2;
	@Column(name = "city")
	private String city;
	@Column(name = "pin_code")
	private String pinCode;
	@Column(name = "state")
	private String state;
	@Column(name = "country")
	private String country;
	@Column(name = "website")
	private String website;
	@Column(name = "remarks")
	private String remarks;
	@Column(name = "status", columnDefinition = "char(2) ")
	private String status;
}
