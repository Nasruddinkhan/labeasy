package com.labeasy.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
	@Column(name = "address_id")
	private Integer addressId;
	@OneToOne(targetEntity=User.class)  
	private User user;
	@Column(name = "address_line_1", length = 250)
    private String addressLine1;
    @Column(name = "address_line_2", length = 250)
    private String addressLine2;
    @Column(name = "landmark", length = 250)
    private String landmark;
    @Column(name = "city", length = 50)
    private String city;
    @Column(name = "state", length = 50)
    private String state;
    @Column(name = "pin_code", length = 10)
    private String pinCode;
    @Column(name = "country", length = 50)
    private String country;
	
}
