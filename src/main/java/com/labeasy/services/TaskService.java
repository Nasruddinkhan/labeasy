package com.labeasy.services;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.labeasy.dto.AppointmentDto;
import com.labeasy.dto.BillingAndInvoiceDto;
import com.labeasy.enums.ApplicationStatus;
import com.labeasy.repsoitory.AppointmentRepository;
import com.labeasy.utils.GenerateInvoice;
import com.labeasy.utils.ObjectUtilMapper;

@Service
@Transactional
public class TaskService {

	private final AppointmentService appointmentService;
	private final GenerateInvoice generateInvoice;
	private final AppointmentRepository appointmentRepo; 
	private final AWSS3Service awsService;
	@Autowired
	public TaskService( final AWSS3Service awsService ,final AppointmentRepository appointmentRepo, AppointmentService appointmentService, GenerateInvoice generateInvoice) {
		super();
		this.appointmentService = appointmentService;
		this.generateInvoice = generateInvoice;
		this.appointmentRepo = appointmentRepo;
		this.awsService = awsService;
	}
	public void generateInvoice() {
		// TODO Auto-generated method stub
		System.out.println("TaskService.generateInvoice()");
		List<AppointmentDto> appointmentDtos = appointmentService
				.findAllInvoiceObject(ApplicationStatus.INACTIVE.getValue());
		appointmentDtos.forEach(obj -> {
			 obj.getAddInvoices().stream().map(m -> transformAppointMent(m, obj))
					.collect(Collectors.toList());
		});

	}
	private AppointmentDto transformAppointMent(BillingAndInvoiceDto andInvoiceDto, AppointmentDto appointmentDto) {
		AppointmentDto dto = ObjectUtilMapper.map(appointmentDto, AppointmentDto.class);
		dto.setAddInvoiceDto(andInvoiceDto);
		String filePath =  generateInvoice.createPDF(dto);
		String s3Path = awsService.uploadFile(new File(filePath), "labeasy-invoice", "http://labeasy-invoice.s3-website-us-east-1.amazonaws.com");
		appointmentRepo.updateInvoiceURL(s3Path, andInvoiceDto.getBillingId());
		appointmentRepo.updateAppointmentStatus(appointmentDto.getAppointmentId());
		return dto;
	}
}
