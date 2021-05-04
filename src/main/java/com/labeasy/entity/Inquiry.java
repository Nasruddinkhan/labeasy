package com.labeasy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

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
