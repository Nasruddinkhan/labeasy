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
@Table(name = "uer_roles")
public class UserRole extends BaseBean implements Serializable  {
    private static final long serialVersionUID = -1782557472225856376L;
    @Id
    @Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "userrolesseq")
	@SequenceGenerator(name = "userrolesseq", sequenceName = "user_roles_seq" , allocationSize = 1,initialValue =  1)
    private Long roleId;
    @Column(name = "role_name", length = 50)
    private String roleName;
    @Column(name = "description", length = 250)
    private String description;
    @Column(name = "status" )
    private String status;
}
