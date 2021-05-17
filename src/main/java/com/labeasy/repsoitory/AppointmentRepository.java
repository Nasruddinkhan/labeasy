package com.labeasy.repsoitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labeasy.entity.Appointment;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

}
