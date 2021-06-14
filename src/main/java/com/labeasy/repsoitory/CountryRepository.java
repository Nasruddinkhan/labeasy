package com.labeasy.repsoitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labeasy.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {

}
