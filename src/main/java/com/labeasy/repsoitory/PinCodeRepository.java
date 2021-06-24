package com.labeasy.repsoitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labeasy.entity.PinCode;

@Repository
public interface PinCodeRepository extends JpaRepository<PinCode, Long> {

	

}
