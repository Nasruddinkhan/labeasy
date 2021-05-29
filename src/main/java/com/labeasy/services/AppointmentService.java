package com.labeasy.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.labeasy.dto.AppointmentDto;
import com.labeasy.dto.BillingAndInvoiceDto;
import com.labeasy.entity.Appointment;
import com.labeasy.entity.BillingAndInvoice;
import com.labeasy.entity.TestNames;
import com.labeasy.utils.ObjectUtilMapper;

public interface AppointmentService {

	AppointmentDto addAppointment(AppointmentDto appointmentDto);
	List<AppointmentDto> findAllAppointments();
	AppointmentDto findByAppointmentId(Long appId);
	
	public static AppointmentDto from(Appointment appointment) {
		String noOfTest = appointment.getTestNames().parallelStream().map(TestNames::getTestId).collect(Collectors.toList()).toString();
		AppointmentDto appointmentDto = ObjectUtilMapper.map(appointment, AppointmentDto.class);
		appointmentDto.setTestList(noOfTest);
		appointmentDto.setAndInvoiceDto(ObjectUtilMapper.map(appointment.getBillingAndInvoices().parallelStream().sorted(Comparator.comparing(BillingAndInvoice::getBillingId)).collect(Collectors.toList()).get(0),BillingAndInvoiceDto.class));
		return appointmentDto;
	}
	
}
