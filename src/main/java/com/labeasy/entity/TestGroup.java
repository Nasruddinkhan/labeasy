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
@Table(name = "test_group")
public class TestGroup extends BaseBean implements Serializable  {

	private static final long serialVersionUID = 6549598896213962887L;

	@Id
    @Column(name = "group_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "testgroupseq")
	@SequenceGenerator(name = "testgroupseq", sequenceName = "group_id" , allocationSize = 1,initialValue =  1)
    private Long groupId;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "description", length = 150)
    private String description;
    @Column(name = "status" )
    private String status;
    

    

}
