package com.labeasy.controller;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class Test {
	void print(Object obj) {
		System.out.println("obj ");
	}

	void print(String obj) {
		System.out.println("string obj ");
	}

	public static void main(String[] args) {

//System.out.println("Password:::::" + generateString());

		
		
		//$2a$10$MW32GAFhFjaHZZLnBKreje.o87qUjOJ8rGwveRQuJlMRl5mAvoj2C
		//System.out.println(new BCryptPasswordEncoder().encode("test"));
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = "test";
		String encodedPassword = passwordEncoder.encode(password);
		System.out.println();
		System.out.println("Password is         : " + password);
		System.out.println("Encoded Password is : " + encodedPassword);
		
		
		boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
		System.out.println("Password : " + password + "   isPasswordMatch    : " + isPasswordMatch);

		password = "yawin";
		isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
		System.out.println("Password : " + password + "           isPasswordMatch    : " + isPasswordMatch);
	
		
	}
	
	
	 public static String generateString() {
	        String uuid = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
	        return "uuid = " + uuid;
	    }
	
		
}

