package com.labeasy.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "logins_persistent")
public class PersistentLogins {

  @Id
  @Column(name = "SERIES")
  private String series;

  @Column(name = "USERNAME", nullable = false)
  private String username;

  @Column(name = "TOKEN", nullable = false)
  private String token;

  @Column(name = "LAST_USED", nullable = false)
  private Date lastUsed;
  
  @Column(name = "CREATED_DATE")
  @CreationTimestamp
  private LocalDateTime createdDate;

}
