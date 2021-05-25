package com.labeasy.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

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
public abstract   class BaseBean {
	
	@CreatedBy
    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    @CreationTimestamp
    private LocalDateTime createdDate;

    @LastModifiedBy
    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "update_date")
    @UpdateTimestamp
    private LocalDateTime  updateDate;
}
