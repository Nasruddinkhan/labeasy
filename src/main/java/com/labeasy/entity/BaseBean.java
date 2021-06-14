package com.labeasy.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author Nasruddin Khan
 */
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract   class BaseBean<U> {
	
	@CreatedBy
    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date  createdDate;

    @LastModifiedBy
    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "update_date")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date   updateDate;
}
