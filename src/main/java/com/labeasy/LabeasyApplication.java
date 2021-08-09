package com.labeasy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.labeasy.services.DashboardService;

@EnableJpaAuditing
@SpringBootApplication
public class LabeasyApplication implements CommandLineRunner {
	
	@Autowired
	private DashboardService menuRepository;

	public static void main(String[] args) {
		SpringApplication.run(LabeasyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		menuRepository.findAllMenus().forEach(System.out::println);
	}

}
