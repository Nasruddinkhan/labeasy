package com.labeasy;

import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.labeasy.dto.ScheduleEmailDto;
import com.labeasy.services.EmailJobSchedulerService;
import com.labeasy.services.UserService;

@EnableJpaAuditing
@SpringBootApplication
public class LabeasyApplication implements CommandLineRunner {
//implements CommandLineRunner {
	@Value("${spring.mail.username}")
	private String mailFrom;

	@Autowired
	private UserService userService;

	@Autowired
	private JavaMailSender emailSender;
	@Autowired
	VelocityEngine velocityEngine;
	@Autowired
	EmailJobSchedulerService emailJobSchedulerService;
	@Autowired 
   	private  MessageSource messageSource;
	public static void main(String[] args) {
		SpringApplication.run(LabeasyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(messageSource.getMessage("VM", null, null));
		Map<String, Object> map = new HashMap<>(); 
		map.put("email","nasruddinkhan44@gmail.com "); 
		map.put("password", "sdgsdfgdsgdsfg");
		ScheduleEmailDto scheduleEmailRequest = ScheduleEmailDto.builder()
				.body(map)
				.subject("Test mail")
				.timeZone(ZoneId.of("Asia/Kolkata"))
				.templateName("invoice")
				.dateTime(LocalDateTime.parse("2021-06-14T01:25:21.374")).email("nasruddinkhan44@gmail.com").build();
		System.out.println(emailJobSchedulerService.scheduleEmail(scheduleEmailRequest));
	}
}
