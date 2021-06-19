package com.labeasy.job;

import static com.labeasy.utils.CommonUtils.contextFunction;

import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import com.labeasy.constant.Constant;
import com.labeasy.utils.Messages;

@Component
public class EmailJob extends QuartzJobBean {
	private static final Logger logger = LoggerFactory.getLogger(EmailJob.class);
	@Autowired
	VelocityEngine velocityEngine;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private MailProperties mailProperties;

	@Autowired
	private Messages messages;

	@SuppressWarnings("unchecked")
	@Override
	protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		logger.info("Executing Job with key {}", jobExecutionContext.getJobDetail().getKey());
		JobDataMap jobDataMap = jobExecutionContext.getMergedJobDataMap();
		String subject = jobDataMap.getString("subject");
		Map<String, Object> body = (Map<String, Object>) jobDataMap.get("body");
		String recipientEmail = jobDataMap.getString("email");
		String template = jobDataMap.getString("template");
		sendMail(mailProperties.getUsername(), recipientEmail, subject, body, template);
	}

	private void sendMail(String fromEmail, String toEmail, String subject, Map<String, Object> body, String template) {
		try {
			logger.info("Sending Email to {}", toEmail);
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, StandardCharsets.UTF_8.toString());
			messageHelper.setSubject(subject);
			messageHelper.setText(geContentFromTemplate(body, template), true);
			messageHelper.setFrom(fromEmail);
			messageHelper.setTo(toEmail);
			mailSender.send(message);
			System.out.println("EmailJob.sendMail() successfully");
		} catch (MessagingException ex) {
			logger.error("Failed to send email to {}", toEmail);
		}
	}

	public String geContentFromTemplate(Map<String, Object> model, String template) {
		System.out.println("EmailJob.geContentFromTemplate()");
		String content = null;
		try {
			String getTemplateName = messages.get(Constant.TAMPLATE_LOCATION) + template + messages.get(Constant.VM);
			Optional.ofNullable(getTemplateName).orElseThrow(
					() -> new Exception("Unsupported value :getTemplateName coming null " + getTemplateName));
			Template t = velocityEngine.getTemplate(getTemplateName);
			StringWriter writer = new StringWriter();
			t.merge(contextFunction.apply(model), writer);
			content = writer.toString();
			System.out.println("EmailJob.geContentFromTemplate() content " + content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content;
	}

}