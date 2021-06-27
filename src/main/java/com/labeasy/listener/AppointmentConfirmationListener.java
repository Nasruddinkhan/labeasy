package com.labeasy.listener;

import static com.labeasy.constant.Constant.NAME;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.labeasy.constant.Constant;
import com.labeasy.dto.AppointmentDto;
import com.labeasy.dto.ScheduleEmailDto;
import com.labeasy.dto.ScheduleEmailResponseDto;
import com.labeasy.event.AppointmentConfirmationEvent;
import com.labeasy.services.EmailJobSchedulerService;
import com.labeasy.utils.Messages;

@Component
public class AppointmentConfirmationListener implements ApplicationListener<AppointmentConfirmationEvent> {
	private final EmailJobSchedulerService emailJobSchedulerService;
	private final Messages messages;

	@Autowired
	public AppointmentConfirmationListener(final EmailJobSchedulerService emailJobSchedulerService,
			final Messages messages) {
		super();
		this.emailJobSchedulerService = emailJobSchedulerService;
		this.messages = messages;
	}

	

	private void confirmBooking(AppointmentDto event) {
		System.out.println("AppointmentConfirmationListener.confirmBooking() start ["+event+"]");
		ScheduleEmailResponseDto emailResponseDto = Optional.of(event)
				.map(AppointmentConfirmationListener::getEmailObject).map(this::getScheduleEmailObject)
				.orElseThrow(RuntimeException::new);
		System.out.println("AppointmentConfirmationListener.confirmBooking() end ["+emailResponseDto+"]");

	}

	private static Map<String, Object> getEmailObject(AppointmentDto appointmentDto) {
		System.out.println("AppointmentConfirmationListener.getEmailObject()"+appointmentDto.getAppointmentDate()+" "+appointmentDto.getAppointmentTime());
		Map<String, Object> map = new HashMap<>();
		map.put(NAME, appointmentDto.getName());
		map.put("email", appointmentDto.getEmailId());
		map.put("appointmentId", appointmentDto.getAppointmentId());
		map.put("appointmentDate", appointmentDto.getAppointmentDate()+" "+ appointmentDto.getAppointmentTime().format(DateTimeFormatter.ofPattern("HH:mm:ss a")));
		return map;

	}

	private ScheduleEmailResponseDto getScheduleEmailObject(Map<String, Object> mailObject) {
		return emailJobSchedulerService.scheduleEmail(ScheduleEmailDto.builder().body(mailObject)
				.subject(messages.get(Constant.APPOINTMENT_CONFIRMATION_SUBJECT)).timeZone(ZoneOffset.systemDefault())
				.templateName(messages.get(Constant.APPOINTMENT_COFIRMATION_TEMPLATE))
				.dateTime(LocalDateTime.now().plusMinutes(1)).email(String.valueOf(mailObject.get("email"))).build());
	}


    

	@Override
	public void onApplicationEvent(AppointmentConfirmationEvent event) {
		// TODO Auto-generated method stub
		this.confirmBooking(event.getDto());

	}
}
