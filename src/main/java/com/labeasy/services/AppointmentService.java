package com.labeasy.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;
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

	public default AppointmentDto from(Appointment appointment) {
		String noOfTest = appointment.getTestNames().parallelStream().map(TestNames::getTestId)
				.collect(Collectors.toList()).toString();
		AppointmentDto appointmentDto = ObjectUtilMapper.map(appointment, AppointmentDto.class);
		appointmentDto.setTestList(noOfTest);
		Set<BillingAndInvoice> andInvoices = appointment.getBillingAndInvoices();
		appointmentDto.setAndInvoices(ObjectUtilMapper.mapAll(andInvoices, BillingAndInvoiceDto.class));
		Optional<BillingAndInvoice> presenTinvoice = andInvoices.stream().filter(BillingAndInvoice::isActive).findAny();
		if (presenTinvoice.isPresent())
			appointmentDto.setAndInvoiceDto(ObjectUtilMapper.map(presenTinvoice.get(), BillingAndInvoiceDto.class));
		return appointmentDto;
	}

	BillingAndInvoiceDto clearDlueAmount(Long appId, Boolean isActive, String paymentmode);

}
