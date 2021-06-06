package com.labeasy;

import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.labeasy.services.UserService;

@EnableJpaAuditing
@SpringBootApplication
public class LabeasyApplication {
//implements CommandLineRunner {
	@Value("${spring.mail.username}")
	private String mailFrom;

	@Autowired
	private UserService userService;

	@Autowired
	private JavaMailSender emailSender;

	@Autowired
	VelocityEngine velocityEngine;

	public static void main(String[] args) {
		SpringApplication.run(LabeasyApplication.class, args);
	}

	//@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("email", "hamidkhan43@ymail.com ");
		map.put("password", "sdgsdfgdsgdsfg");
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
				StandardCharsets.UTF_8.name());
		FileSystemResource fr = new FileSystemResource("D:\\Invoice\\invoice.pdf");
		helper.addAttachment("invoice.pdf", fr);
		helper.setTo("hamidkhan43@ymail.com ");
		helper.setText(geContentFromTemplate(map), true);
		helper.setSubject("testmail");
		helper.setFrom(mailFrom);
		emailSender.send(message);
		userService.getAllPhlebotomistList().forEach(System.out::println);
	}

	public String geContentFromTemplate(Map<String, Object> model) {
		String content = null;
		try {
			String getTemplateName = "templates/invoice.vm";
			Optional.ofNullable(getTemplateName).orElseThrow(
					() -> new Exception("Unsupported value :getTemplateName coming null " + getTemplateName));
			Template t = velocityEngine.getTemplate(getTemplateName);
			StringWriter writer = new StringWriter();
			t.merge(setContext(model), writer);
			content = writer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content;
	}

	private VelocityContext setContext(Map<String, Object> model) {
		VelocityContext context = new VelocityContext();
		model.forEach((k, v) -> {
			context.put(k, v);
		});
		return context;
	}

}
