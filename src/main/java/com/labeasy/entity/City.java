package com.labeasy.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "city")
public class City extends BaseBean implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7180206724218385585L;
	/**
	 * 
	 */
	
	@Id
	@Column(name = "city_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cityseq")
	@SequenceGenerator(name = "cityseq", sequenceName = "city_seq", allocationSize = 1, initialValue = 1)
	private Long cityId;
	@Column(name = "city_name", length = 30)
	private String cityName;
	@ManyToOne
	@JoinColumn(name = "state_id", nullable = false)
	private State state;
	@OneToMany(mappedBy = "city",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PinCode> pinCode;
}
