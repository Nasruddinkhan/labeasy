package com.labeasy.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "pin_code")
public class PinCode extends BaseBean implements Serializable {
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4404629986486830575L;
	@Id
	@Column(name = "pin_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pinseq")
	@SequenceGenerator(name = "pinseq", sequenceName = "pin_seq", allocationSize = 1, initialValue = 1)
	private Long pinId;
	@Column(name = "pin_code", length = 10)
	private String pinCode;
	@Column(name="area_name")
	private String areaName;
	@ManyToOne
	@JoinColumn(name = "city_id", nullable = false)
	private City city;
}
