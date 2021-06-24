package com.labeasy.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "country")
public class Country extends BaseBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -102616456174348450L;
	@Id
	@Column(name = "country_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "countryseq")
	@SequenceGenerator(name = "countryseq", sequenceName = "country_seq", allocationSize = 1, initialValue = 1)
	private Long countryId;
	@Column(name = "country_name", length = 30)
	private String countryName;
	@Column(name = "country_code", length = 3)
	private String countryCode;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
	private Set<State> state = null;
}
