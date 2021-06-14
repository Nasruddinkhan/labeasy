package com.labeasy.listener;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import static com.labeasy.constant.Constant.*;

import com.labeasy.constant.Constant;
import com.labeasy.dto.ScheduleEmailDto;
import com.labeasy.dto.ScheduleEmailResponseDto;
import com.labeasy.dto.UserDto;
import com.labeasy.event.OnUserRegistrationCompleteEvent;
import com.labeasy.services.EmailJobSchedulerService;
import com.labeasy.utils.Messages;

@Component
public class UserRegistrationListener implements ApplicationListener<OnUserRegistrationCompleteEvent> {
	private static final Logger logger = LoggerFactory.getLogger(UserRegistrationListener.class);
	private final EmailJobSchedulerService emailJobSchedulerService;
	private final Messages messages;

	@Autowired
	public UserRegistrationListener(final EmailJobSchedulerService emailJobSchedulerService, final Messages messages) {
		super();
		this.emailJobSchedulerService = emailJobSchedulerService;
		this.messages = messages;
	}

	@Override
	public void onApplicationEvent(OnUserRegistrationCompleteEvent event) {
		this.confirmRegistration(event);
	}

	private void confirmRegistration(OnUserRegistrationCompleteEvent event) {
		UserDto dto = event.getDto();
		Map<String, Object> map = new HashMap<>();
		map.put(NAME, dto.getFirstName().concat(" ").concat(dto.getLastName()).concat(","));
		map.put(PASSWORD, dto.getMobileNo());
		map.put(USER_NAME, dto.getEmailId());
		ScheduleEmailDto scheduleEmailRequest = ScheduleEmailDto.builder().body(map)
				.subject(messages.get(CONFIRMATION_SUBJECT)).timeZone(ZoneOffset.systemDefault())
				.templateName(messages.get(Constant.REGISTRATION_COFIRMATION_TEMPLATE))
				.dateTime(LocalDateTime.now().plusMinutes(1)).email(dto.getEmailId()).build();
		ScheduleEmailResponseDto scheduleEmailResponseDto = emailJobSchedulerService
				.scheduleEmail(scheduleEmailRequest);
		logger.info("scheduleEmailResponseDto{}->", scheduleEmailResponseDto);
	}

}
