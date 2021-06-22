package com.labeasy.entity;

import java.io.Serializable;
import java.util.Set;

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
@Table(name = "state")
public class State extends BaseBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8349809214254790297L;
	@Id
	@Column(name = "state_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stateseq")
	@SequenceGenerator(name = "stateseq", sequenceName = "state_seq", allocationSize = 1, initialValue = 1)
	private Long stateId;
	@Column(name = "state_name", length = 30)
	private String stateName;
	@Column(name = "state_code", length = 3)
	private String stateCode;
	@ManyToOne
	@JoinColumn(name = "country_id", nullable = false)
	private Country country;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "state" ,fetch = FetchType.LAZY)
	private Set<City> city;
}
