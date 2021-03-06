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
@Table(name = "uer_roles")
public class UserRole extends BaseBean implements Serializable  {
    private static final long serialVersionUID = -1782557472225856376L;
    @Id
    @Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "userrolesseq")
	@SequenceGenerator(name = "userrolesseq", sequenceName = "user_roles_seq" , allocationSize = 1,initialValue =  1)
    private Long roleId;
    @Column(name = "role_code", length = 20)
    private String roleCode;
    @Column(name = "role_type", length = 50)
    private String roleType;
    @Column(name = "role_name", length = 50)
    private String roleName;
    @Column(name = "description", length = 250)
    private String description;
    @Column(name = "status" )
    private String status;
    @OneToMany(mappedBy = "userRole", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<User> users;
}
