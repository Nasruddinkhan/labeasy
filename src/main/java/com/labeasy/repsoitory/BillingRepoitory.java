package com.labeasy.repsoitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labeasy.entity.BillingAndInvoice;

@Repository
public interface BillingRepoitory extends JpaRepository<BillingAndInvoice, Long>{

}
