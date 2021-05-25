package com.labeasy.services.impl;

import static com.labeasy.utils.CommonUtils.removeFirstLastElementOnstring;
import static com.labeasy.utils.CommonUtils.transformGenricList;
import static com.labeasy.utils.ObjectUtilMapper.map;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.labeasy.dto.AppointmentDto;
import com.labeasy.entity.Appointment;
import com.labeasy.entity.BillingAndInvoice;
import com.labeasy.repsoitory.AppointmentRepository;
import com.labeasy.repsoitory.TestNamesRepository;
import com.labeasy.services.AppointmentService;

@Service
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
		Appointment appointment = map(appointmentDto, Appointment.class);
		BillingAndInvoice andInvoice = map(appointmentDto.getAndInvoiceDto(), BillingAndInvoice.class);
		andInvoice.setAppointment(appointment);
		Set<BillingAndInvoice> billingAndInvoices = new HashSet<>();
		billingAndInvoices.add(andInvoice);
		appointment.setBillingAndInvoices(billingAndInvoices);
		setTestNames(appointment, appointmentDto.getTestList());
		return map(appointmentRepository.save(appointment), AppointmentDto.class);
	}
	/**
	 * 
	 * @param appointment
	 * @param testList
	 */
	private void setTestNames(Appointment appointment,String testList ) {
		appointment.setTestNames(testNamesRepository
				.findAllById(transformGenricList(removeFirstLastElementOnstring.apply(testList), Long::parseLong))
				.stream().collect(Collectors.toSet()));
	}

}
