package com.labeasy.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.labeasy.dto.AppointmentDto;
import com.labeasy.enums.AppointmentStatus;

@Component
public class EmailTaskService {

	private final AppointmentService appointmentService;

	@Autowired
	public EmailTaskService(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;

	}

	public void startSendEmail() {
		// TODO Auto-generated method stub
		System.out.println("EmailTaskService.startSendEmail() start");
		Map<String, List<AppointmentDto>> lsitOfMailObj = appointmentService
				.findEmailList(AppointmentStatus.ASSIGNED_TO_PHLEBO.getValue(), "N").parallelStream()
				.collect(Collectors.groupingBy(AppointmentDto::getAppStatus));
		lsitOfMailObj.forEach((k, v) -> System.out.println(k + " " + v));
		System.out.println("EmailTaskService.startSendEmail() end");
	}

}
