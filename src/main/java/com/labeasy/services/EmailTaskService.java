package com.labeasy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.labeasy.utils.GenerateInvoice;

@Component
public class EmailTaskService {

	private final AppointmentService appointmentService;
	private final GenerateInvoice  generateInvoice;
	@Autowired
	public EmailTaskService(AppointmentService appointmentService, final GenerateInvoice  generateInvoice) {
		this.appointmentService = appointmentService;
		 this.generateInvoice  = generateInvoice;
	}

	public void startSendEmail() {
		// TODO Auto-generated method stub
		System.out.println("EmailTaskService.startSendEmail() start");
		/*
		 * Map<String, List<AppointmentDto>> lsitOfMailObj = appointmentService
		 * .findEmailList(AppointmentStatus.ASSIGNED_TO_PHLEBO.getValue(),
		 * "N").parallelStream()
		 * .collect(Collectors.groupingBy(AppointmentDto::getAppStatus));
		 * lsitOfMailObj.forEach((k, v) ->{ v.forEach(vm ->
		 * generateInvoice.createPDF(vm));
		 * 
		 * });ō
		 */
		System.out.println("EmailTaskService.startSendEmail() end");
	}

}
