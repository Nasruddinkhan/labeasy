package com.labeasy.repsoitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labeasy.entity.Menus;

@Repository
public interface MenuRepository extends JpaRepository<Menus, String>{


	

}
