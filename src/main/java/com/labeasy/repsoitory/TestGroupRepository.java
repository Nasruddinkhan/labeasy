package com.labeasy.repsoitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labeasy.entity.TestGroup;

/**
 * @author Nasruddin
 */
@Repository
public interface TestGroupRepository extends JpaRepository<TestGroup, Long> {
    List<TestGroup> findByStatus(String status);

}
