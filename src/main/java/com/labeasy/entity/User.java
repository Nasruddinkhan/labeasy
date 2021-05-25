package com.labeasy.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User extends BaseBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1758784590151693711L;
	@Id
	@Column(name = "user_id", length = 100)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String userId;
	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "enabled", nullable = false)
	private boolean enabled;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

	@Column(name = "first_name", length = 50)
	private String firstName;
	@Column(name = "last_name", length = 20)
	private String lastName;

	@Column(name = "mobile_no", length = 10)
	private String mobileNo;
	@Column(name = "alternate_no", length = 10)
	private String cantactNo1;
	@Column(name = "email_Id", length = 100)
	private String emailId;

	@Column(name = "is_active", columnDefinition = "boolean default true", nullable = false)
	private boolean isActive;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "MANAGER_ID")
	private User manager;

	@OneToMany(mappedBy = "manager")
	private Set<User> subordinates;
	@Column(name = "account_non_locked", nullable = false)
	private boolean accountNonLocked;

	@Column(name = "failed_attempt")
	private int failedAttempt;

	@Column(name = "lock_time")
	private Date lockTime;

	

}
