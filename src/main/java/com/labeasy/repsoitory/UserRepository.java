package com.labeasy.repsoitory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.labeasy.entity.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, String> {

	Optional<User> findByEmailId(String username);

	@Query("UPDATE User u SET u.failedAttempt = ?1 WHERE u.emailId = ?2")
    @Modifying
    public void updateFailedAttempts(int failAttempts, String email);


}
