package com.labeasy.repsoitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labeasy.entity.TestNames;


@Repository
public interface TestNamesRepository extends JpaRepository<TestNames, Long> {
    List<TestNames> findByStatus(String status);
}
