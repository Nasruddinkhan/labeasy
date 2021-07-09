package com.labeasy.repsoitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labeasy.entity.Lab;

public interface LabRepository extends JpaRepository<Lab, Long>{

}
