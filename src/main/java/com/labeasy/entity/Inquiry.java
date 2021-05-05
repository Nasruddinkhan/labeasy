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

/**
 * @author Nasruddin
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "inquiry")
public class Inquiry extends BaseBean implements Serializable  {
    private static final long serialVersionUID = -1782557472225856376L;
    @Id
    @Column(name = "inq_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "inquiryseq")
	@SequenceGenerator(name = "inquiryseq", sequenceName = "inquiry_seq" , allocationSize = 1,initialValue =  1)
    private Long inqId;
    @Column(name = "name")
    private String name;
    @Column(name = "mobile_no")
    private String mobileNo;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "status")
    private String status;
    @Column(name = "company_Id")
    private Long companyId;
}
