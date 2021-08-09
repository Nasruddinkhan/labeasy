package com.labeasy.repsoitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labeasy.entity.B2BRegistration;

public interface B2BRegistrationRepository extends JpaRepository<B2BRegistration, Long>{
	List<B2BRegistration> findByStatus(String status);

}
