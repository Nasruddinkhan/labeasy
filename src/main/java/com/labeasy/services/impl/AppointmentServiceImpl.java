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
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.labeasy.dto.AppointmentDto;
import com.labeasy.dto.AppointmentUpdateDto;
import com.labeasy.dto.BillingAndInvoiceDto;
import com.labeasy.eception.NotFoundException;
import com.labeasy.entity.Appointment;
import com.labeasy.entity.BillingAndInvoice;
import com.labeasy.entity.User;
import com.labeasy.enums.ApplicationStatus;
import com.labeasy.enums.AppointmentStatus;
import com.labeasy.repsoitory.AppointmentRepository;
import com.labeasy.repsoitory.TestNamesRepository;
import com.labeasy.repsoitory.UserRepository;
import com.labeasy.services.AppointmentService;

@Service("appointmentService")
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

	Predicate<String> isVisited = (visited) -> ApplicationStatus.ACTIVE.getValue().equals(visited);
	BiFunction<String, Long, String> isCustomerVisit = (visited, assignTo) -> isVisited.test(visited)
			? AppointmentStatus.SAMPLE_COLLECTED.getValue()
			: getStatus.apply(assignTo);
	private final AppointmentRepository appointmentRepository;
	private final TestNamesRepository testNamesRepository;
	private final UserRepository userRepository;
	@PersistenceContext
	EntityManager em;

	@Autowired
	public AppointmentServiceImpl(final AppointmentRepository appointmentRepository,
			final UserRepository userRepository, final TestNamesRepository testNamesRepository) {
		super();
		this.appointmentRepository = appointmentRepository;
		this.testNamesRepository = testNamesRepository;
		this.userRepository = userRepository;
	}

	@Override
	public AppointmentDto addAppointment(AppointmentDto appointmentDto) {
		Appointment appointment = map(appointmentDto, Appointment.class);
		setBillingAndInvoice(appointment, appointmentDto);
		appointment.setAppointmentDate(getAppointmentDate(appointmentDto.getAppointmentDate()));
		appointment
				.setAppStatus(isCustomerVisit.apply(appointmentDto.getVisitType(), appointmentDto.getAssignTo()));
		appointment.setActive(true);
		if (Objects.nonNull(appointmentDto.getAssignTo())) {
			appointment.setAssign(findAssignUser(appointmentDto.getAssignTo()));
		}
		setTestNames(appointment, appointmentDto.getTestList());
		return this.from(appointmentRepository.save(appointment));
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
		BillingAndInvoice andInvoice = map(appointmentDto.getAddInvoiceDto(), BillingAndInvoice.class);
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
		System.out.println("testListtestListtestListtestList::"+testList);
		appointment.setTestNames(testNamesRepository
				.findAllById(transformGenricList(removeFirstLastElementOnstring.apply(testList), Long::parseLong))
				.stream().collect(Collectors.toSet()));
	}

	/**
	 * appointmentDtos.stream().sorted(Comparator.comparing(AppointmentDto::getAppointmentId).reversed()).collect(Collectors.toList());
	 */
	@Override
	public List<AppointmentDto> findAllAppointments() {
		return appointmentRepository.findByIsActiveTrue().stream().map(this::from).collect(Collectors.toList());
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
		secInvoices.setDueAmount(0.0);
		secInvoices.setBillingId(0L);
		secInvoices.setAdvancePayment(firstInvoice.getDueAmount());
		secInvoices.setTotalAmount(firstInvoice.getTotalAmount());
		secInvoices.setActive(true);
		secInvoices.setPaymentDate(LocalDateTime.now());
		secInvoices.setDiscountReason(firstInvoice.getDiscountReason());
		secInvoices.setDiscountAmount(firstInvoice.getDiscountAmount());
		firstInvoice.setActive(false);
	}

	@Override
	public int updateAppointmentStatus(AppointmentUpdateDto appointmentUpdateDto) {
		return appointmentRepository.findAllById(appointmentUpdateDto.getAppointment()).stream()
				.map(appointment -> myLambda.apply(appointmentUpdateDto, appointment)).collect(Collectors.toList())
				.size();
	}

	private BiFunction<AppointmentUpdateDto, Appointment, Appointment> myLambda = (appointmentUpdateDto,
			appointment) -> {
		appointment.setAppStatus(appointmentUpdateDto.getStatus());
		if (Objects.nonNull(appointmentUpdateDto.getAssignTo())) {
			appointment.setAssign(findAssignUser(Long.parseLong(appointmentUpdateDto.getAssignTo())));
		}
		return appointment;
	};

	private User findAssignUser(Long assignTO) {
		return userRepository.findById(assignTO).orElseThrow(() -> new NotFoundException("employyee naot present"));

	}

	static Function<Long, String> getStatus = assignTo -> (Objects.isNull(assignTo))
			? AppointmentStatus.NEWLY_CREATED_APPOINTMENT.getValue()
			: AppointmentStatus.ASSIGNED_TO_PHLEBO.getValue();

	@Override
	public List<AppointmentDto> findEmailList(String status, String isEmailFlag) {
		// appointmentRepository.find
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Appointment> cq = cb.createQuery(Appointment.class);
		Root<Appointment> appointment = cq.from(Appointment.class);
		javax.persistence.criteria.Predicate emailFlag = cb.equal(appointment.get("isEmailStatus"), isEmailFlag);
		cq.where(emailFlag);
		return em.createQuery(cq).getResultList().stream().map(this::from).collect(Collectors.toList());
	}

	@Override
	public List<AppointmentDto> findAllInvoiceObject(String status) {
		// TODO Auto-generated method stub
		return appointmentRepository.findByInvoiceStatus(status).stream().map(this::from).collect(Collectors.toList());
	}

}
