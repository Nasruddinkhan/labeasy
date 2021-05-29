package com.labeasy.services.impl;

import static com.labeasy.utils.CommonUtils.removeFirstLastElementOnstring;
import static com.labeasy.utils.CommonUtils.transformGenricList;
import static com.labeasy.utils.CommonUtils.transformTheDateFormat;
import static com.labeasy.utils.ObjectUtilMapper.map;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.labeasy.dto.AppointmentDto;
import com.labeasy.eception.NotFoundException;
import com.labeasy.entity.Appointment;
import com.labeasy.entity.BillingAndInvoice;
import com.labeasy.enums.ApplicationStatus;
import com.labeasy.repsoitory.AppointmentRepository;
import com.labeasy.repsoitory.TestNamesRepository;
import com.labeasy.services.AppointmentService;

@Service("appointmentService")
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

	private final AppointmentRepository appointmentRepository;
	private final TestNamesRepository testNamesRepository;

	public AppointmentServiceImpl(final AppointmentRepository appointmentRepository,
			final TestNamesRepository testNamesRepository) {
		super();
		this.appointmentRepository = appointmentRepository;
		this.testNamesRepository = testNamesRepository;
	}

	@Override
	public AppointmentDto addAppointment(AppointmentDto appointmentDto) {
		Appointment appointment =
				map(appointmentDto, Appointment.class);
		setBillingAndInvoice(appointment, appointmentDto);
		appointment.setAppointmentDate(getAppointmentDate(appointmentDto.getAppointmentDate()));
		appointment.setStatus(ApplicationStatus.ACTIVE.getValue());
		appointment.setActive(true);
		setTestNames(appointment, appointmentDto.getTestList());
		return map(appointmentRepository.save(appointment), AppointmentDto.class);
	}
	/**
	 * 
	 * @param appointmentDate
	 * @return
	 */
	private LocalDate getAppointmentDate(String appointmentDate) {
		return transformTheDateFormat(appointmentDate, DateTimeFormatter.ISO_DATE,
				(date, format) -> LocalDate.parse(date, format));
	}
	/**
	 * 
	 * @param appointment
	 * @param appointmentDto
	 */
	private void setBillingAndInvoice(Appointment appointment, AppointmentDto appointmentDto) {
		BillingAndInvoice andInvoice = map(appointmentDto.getAndInvoiceDto(), BillingAndInvoice.class);
		andInvoice.setAppointment(appointment);
		andInvoice.setPaymentDate(LocalDateTime.now());
		Set<BillingAndInvoice> billingAndInvoices = new HashSet<>();
		billingAndInvoices.add(andInvoice);
		appointment.setBillingAndInvoices(billingAndInvoices);
	}

	/**
	 * 
	 * @param appointment
	 * @param testList
	 */
	private void setTestNames(Appointment appointment, String testList) {
		System.out.println("AppointmentServiceImpl.setTestNames() ["+testList+"]");
		appointment.setTestNames(testNamesRepository
				.findAllById(transformGenricList(removeFirstLastElementOnstring.apply(testList), Long::parseLong))
				.stream().collect(Collectors.toSet()));
	}
	/**
	 * 
	 */
	@Override
	public List<AppointmentDto> findAllAppointments() {
		return appointmentRepository.findByIsActiveTrue().parallelStream().map(AppointmentService::from)
				.collect(Collectors.toList());
	}

	@Override
	public AppointmentDto findByAppointmentId(Long appId) {
		return appointmentRepository
				.findById(appId).map(AppointmentService::from)
				.orElseThrow(()-> new NotFoundException("appointment id not found"));
	}

}
