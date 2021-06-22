package com.labeasy.repsoitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labeasy.entity.City;
import com.labeasy.entity.State;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
	List<City> findByState(State state);

}
