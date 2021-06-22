package com.labeasy.repsoitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labeasy.entity.Country;
import com.labeasy.entity.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

	List<State> findByCountry(Country country);

}
