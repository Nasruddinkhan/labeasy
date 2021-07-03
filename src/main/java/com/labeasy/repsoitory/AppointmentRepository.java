package com.labeasy.repsoitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.labeasy.entity.Appointment;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

	List<Appointment> findByIsActiveTrue();

	List<Appointment> findByInvoiceStatus(String status);
	
	@Query("UPDATE BillingAndInvoice u SET u.invoiceUrl = ?1 WHERE u.billingId = ?2")
    @Modifying
    public void updateInvoiceURL(String invoiceUrl, Long billingId);
	
	@Query("UPDATE Appointment u SET u.invoiceStatus ='Y' WHERE u.appointmentId = ?1")
    @Modifying
    public void updateAppointmentStatus(Long appointmentId);


}
