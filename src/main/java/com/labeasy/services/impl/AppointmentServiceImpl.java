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
import java.util.Objects;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.labeasy.dto.AppointmentDto;
import com.labeasy.dto.AppointmentUpdateDto;
import com.labeasy.dto.BillingAndInvoiceDto;
import com.labeasy.eception.NotFoundException;
import com.labeasy.entity.Appointment;
import com.labeasy.entity.BillingAndInvoice;
import com.labeasy.enums.ApplicationStatus;
import com.labeasy.enums.AppointmentStatus;
import com.labeasy.repsoitory.AppointmentRepository;
import com.labeasy.repsoitory.TestNamesRepository;
import com.labeasy.services.AppointmentService;

@Service("appointmentService")
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

	private final AppointmentRepository appointmentRepository;
	private final TestNamesRepository testNamesRepository;
	
	Predicate<String> isVisited = (visited) ->  ApplicationStatus.ACTIVE.getValue().equals(visited)	;
	BiFunction<String, String, String> isCustomerVisit = (visited, assignTo) -> isVisited.test(visited) ? AppointmentStatus.SAMPLE_COLLECTED.getValue() : getStatus.apply(assignTo);

	@Autowired
	public AppointmentServiceImpl(final AppointmentRepository appointmentRepository,
			final TestNamesRepository testNamesRepository) {
		super();
		this.appointmentRepository = appointmentRepository;
		this.testNamesRepository = testNamesRepository;
	}

	@Override
	public AppointmentDto addAppointment(AppointmentDto appointmentDto) {
		Appointment appointment = map(appointmentDto, Appointment.class);
		setBillingAndInvoice(appointment, appointmentDto);
		appointment.setAppointmentDate(getAppointmentDate(appointmentDto.getAppointmentDate()));
		appointment.setAppStatus(isCustomerVisit.apply(appointmentDto.getCustomerVisited(), appointment.getAssignTo()));
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
		andInvoice.setActive(true);
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
		appointment.setTestNames(testNamesRepository
				.findAllById(transformGenricList(removeFirstLastElementOnstring.apply(testList), Long::parseLong))
				.stream().collect(Collectors.toSet()));
	}

	/**
	 *  appointmentDtos.stream().sorted(Comparator.comparing(AppointmentDto::getAppointmentId).reversed()).collect(Collectors.toList());
	 */
	@Override
	public List<AppointmentDto> findAllAppointments() {
		return appointmentRepository.findByIsActiveTrue().parallelStream().map(this::from).collect(Collectors.toList());
	}

	@Override
	public AppointmentDto findByAppointmentId(Long appId) {
		return appointmentRepository.findById(appId).map(this::from)
				.orElseThrow(() -> new NotFoundException("appointment id not found"));
	}

	private Appointment findByAppointmentById(Long appId) {
		return appointmentRepository.findById(appId)
				.orElseThrow(() -> new NotFoundException("appointment id not found"));
	}

	@Override
	public BillingAndInvoiceDto clearDlueAmount(Long appId, Boolean isActive, String paymentMode) {
		Appointment appointment = findByAppointmentById(appId);
		Set<BillingAndInvoice> andInvoices = appointment.getBillingAndInvoices();
		BillingAndInvoice firstInvoice = andInvoices.stream().filter(BillingAndInvoice::isActive).findFirst()
				.orElseThrow(() -> new NotFoundException("notFound"));
		BillingAndInvoice secInvoices = new BillingAndInvoice();
		setClearDueObject(secInvoices, firstInvoice);
		secInvoices.setAppointment(appointment);
		secInvoices.setPaymentMode(paymentMode);
		andInvoices.add(firstInvoice);
		andInvoices.add(secInvoices);
		appointmentRepository.save(appointment);
		return map(secInvoices, BillingAndInvoiceDto.class);
	}

	private void setClearDueObject(BillingAndInvoice secInvoices, BillingAndInvoice firstInvoice) {
		secInvoices.setPaymentAmmount(0.0);
		secInvoices.setBillingId(0L);
		secInvoices.setAdvancePayment(firstInvoice.getPaymentAmmount());
		secInvoices.setTotalAmmount(firstInvoice.getTotalAmmount());
		secInvoices.setActive(true);
		secInvoices.setPaymentDate(LocalDateTime.now());
		secInvoices.setDiscountReason(firstInvoice.getDiscountReason());
		secInvoices.setDiscountAmmount(firstInvoice.getDiscountAmmount());
		firstInvoice.setActive(false);
	}

	@Override
	public int updateAppointmentStatus(AppointmentUpdateDto appointmentUpdateDto) {
		return  appointmentRepository.findAllById(appointmentUpdateDto.getAppointment())
				.stream().map(appointment->myLambda.apply(appointmentUpdateDto, appointment)).collect(Collectors.toList()).size();
	}
	
	private BiFunction<AppointmentUpdateDto, Appointment, Appointment> myLambda = (appointmentUpdateDto, appointment) -> {
		appointment.setAppStatus(appointmentUpdateDto.getStatus());
		if (Objects.nonNull(appointmentUpdateDto.getAssignTo())) {
			appointment.setAssignTo(appointmentUpdateDto.getAssignTo());
		}
		return appointment;
	};
	
	static UnaryOperator<String> getStatus = assignTo -> (Objects.isNull(assignTo) || assignTo.isEmpty() )
			? AppointmentStatus.NEWLY_CREATED_APPOINTMENT.getValue()
			: AppointmentStatus.ASSIGNED_TO_PHLEBO.getValue();
	
}
