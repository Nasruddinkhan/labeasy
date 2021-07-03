package com.labeasy.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "inquiry_test")
public class InquiryTest implements Serializable  {
    private static final long serialVersionUID = -1782557472225856376L;
    @Id
    @Column(name = "inq_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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