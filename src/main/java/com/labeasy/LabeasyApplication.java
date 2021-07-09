package com.labeasy;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.labeasy.services.AWSS3Service;

@EnableJpaAuditing
@SpringBootApplication
public class LabeasyApplication implements CommandLineRunner{
	@Autowired
	private AWSS3Service awsService;

	public static void main(String[] args) {
		SpringApplication.run(LabeasyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//awsService.uploadFile(new File("D:\\Invoice\\invoice.pdf"), "labeasy-invoice", "http://labeasy-invoice.s3-website-us-east-1.amazonaws.com");
	}
	
}
