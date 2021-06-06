package com.labeasy.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "users")
public class User extends BaseBean implements Serializable {
	private static final long serialVersionUID = -1758784590151693711L;
	@Id
    @Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "usersseq")
	@SequenceGenerator(name = "usersseq", sequenceName = "users_seq" , allocationSize = 1,initialValue =  1)
	private Long id;
	private String userId;
    @Column(name = "first_name", length = 50)
    private String firstName;
    @Column(name = "last_name", length = 50)
    private String lastName;
    @Column(name = "father_spouse_name", length = 50)
    private String fatherSpouseName;
    @Column(name = "gender" , length = 2)
    private String gender;
    @Column(name = "date_of_birth")
    private LocalDate dob;
    @Column(name = "date_of_joining")
    private LocalDate doj;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "mobile_no", length = 15)
    private String mobileNo;
    @Column(name = "alternate_mobile_no", length = 15)
    private String alternateMobileNo;
    @Column(name = "email", length = 50)
    private String emailId;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;
    @Column(name = "adhar_card_no", length = 20)
    private String adharCardNo;
    @Column(name = "pan_card_no", length = 20)
    private String panCardNo;
    @Column(name = "other_id_card_no", length = 30)
    private String otherIdCardNo;
    @Column(name = "remarks")
    private String remarks;
    @Column(name = "role")
    private String roleId;
    @Column(name = "enabled", nullable = false)
	private boolean enabled;
    @Column(name = "is_active", columnDefinition = "boolean default true", nullable = false)
	private boolean isActive;
    @Column(name = "account_non_locked", nullable = false)
	private boolean accountNonLocked;
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "reporting_user_id")
	private User reportingUser;
	/*@OneToMany(mappedBy = "reportingUser")
	private Set<User> subordinates;*/
    @Column(name = "failed_password_count")
    private Integer noOfFailPwdAttempt;
    @Column(name = "login_id_locked_date_time")
    private Date lastLoginDateTime;
	@Column(name = "failed_attempt")
	private int failedAttempt;
	@Column(name = "lock_time")
	private Date lockTime;
    @Column(name = "status")
    private String status;

}
