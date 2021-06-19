package com.labeasy.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.labeasy.dto.AppointmentDto;
import com.labeasy.dto.AppointmentUpdateDto;
import com.labeasy.dto.BillingAndInvoiceDto;
import com.labeasy.dto.TestNamesDto;
import com.labeasy.dto.UserDto;
import com.labeasy.entity.Appointment;
import com.labeasy.entity.BillingAndInvoice;
import com.labeasy.entity.User;
import com.labeasy.utils.ObjectUtilMapper;

public interface AppointmentService {

	AppointmentDto addAppointment(AppointmentDto appointmentDto);

	List<AppointmentDto> findAllAppointments();

	AppointmentDto findByAppointmentId(Long appId);

	public default AppointmentDto from(Appointment appointment) {
		AppointmentDto appointmentDto = ObjectUtilMapper.map(appointment, AppointmentDto.class);
		Set<TestNamesDto> testNamesDtos = ObjectUtilMapper.mapAll(appointment.getTestNames(), TestNamesDto.class);
		String noOfTest = testNamesDtos.parallelStream().map(TestNamesDto::getTestId).collect(Collectors.toList())
				.toString();
		appointmentDto.setTestNames(testNamesDtos);
		appointmentDto.setTestList(noOfTest);
		Set<BillingAndInvoice> andInvoices = appointment.getBillingAndInvoices();
		appointmentDto.setAndInvoices(ObjectUtilMapper.mapAll(andInvoices, BillingAndInvoiceDto.class));
		Optional<BillingAndInvoice> presenTinvoice = andInvoices.stream().filter(BillingAndInvoice::isActive).findAny();
		if (presenTinvoice.isPresent())
			appointmentDto.setAndInvoiceDto(ObjectUtilMapper.map(presenTinvoice.get(), BillingAndInvoiceDto.class));
		if (Objects.nonNull(appointment.getAssign()) &&  appointment.getAssign().getId()>0) {
			User user = appointment.getAssign();
			appointmentDto.setAssignTo(user.getId());
			appointmentDto.setAssignToUserDto(ObjectUtilMapper.map(user, UserDto.class));
		}
		return appointmentDto;
	}

	BillingAndInvoiceDto clearDlueAmount(Long appId, Boolean isActive, String paymentmode);

	int updateAppointmentStatus(AppointmentUpdateDto appointmentUpdateDto);

}
