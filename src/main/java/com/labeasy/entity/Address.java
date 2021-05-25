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
@Table(name ="address")
public class Address implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9130995318647768203L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
	@SequenceGenerator(name =  "address_seq", sequenceName = "address_seq" , allocationSize = 1,initialValue =  1)
	@Column(name = "address_Id")
	private Integer addressId;
	
	@Column(name  ="address_line1", length =  100 )
	private String addressLine1;
	
	@Column(name  ="address_line2", length =  100 )
	private String addressLine2;
	
}
