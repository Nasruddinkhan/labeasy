package com.labeasy.controller;

import static com.labeasy.utils.CommonUtils.SQL_DATE_FORMAT;
import static com.labeasy.utils.CommonUtils.transformTheDateFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.labeasy.dto.AppointmentDto;
import com.labeasy.dto.AppointmentUpdateDto;
import com.labeasy.dto.BillingAndInvoiceDto;
import com.labeasy.services.AppointmentService;
import com.labeasy.services.TestNamesService;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

	private final TestNamesService testNamesService;
	private final AppointmentService appointmentService;

	@Autowired
	public AppointmentController(final TestNamesService testNamesService, final AppointmentService appointmentService) {
		this.testNamesService = testNamesService;
		this.appointmentService = appointmentService;
	}

	/**
	 * 
	 * @param model
	 */
	private void addAppointmentOnLoadData(ModelMap model, AppointmentDto appointmentDto) {
		model.addAttribute("appointment", appointmentDto);
		model.addAttribute("testNameList", testNamesService.findAllTestName());
	}

	@GetMapping("/view-appointment-page")
	public String viewAppointments(ModelMap model) {
		model.addAttribute("appointment", appointmentService.findAllAppointments());
		return "viewappointments";
	}

	@GetMapping("/show-appointment-page")
	public String showAppointment(ModelMap model) {
		AppointmentDto appointmentDto = new AppointmentDto();
		appointmentDto.setAndInvoiceDto(new BillingAndInvoiceDto());
		addAppointmentOnLoadData(model, appointmentDto);
		return "addappointment";
	}

	@PostMapping("/add-appointment")
	public String addAppointments(@ModelAttribute AppointmentDto appointmentDto) {
		appointmentService.addAppointment(appointmentDto);
		return "redirect:view-appointment-page";
	}

	@GetMapping("/editAppointment/{appId}")
	public String editAppointment(@PathVariable Long appId, ModelMap model) {
		addAppointmentOnLoadData(model, appointmentService.findByAppointmentId(appId));
		return "addappointment";
	}

	@GetMapping("/cleardue-popup")
	public String clearDluePopup(@RequestParam("appId") Long appId, @RequestParam("advPay") Double advPay,
			@RequestParam("dueAmt") Double dueAmt, @RequestParam("paymentDate") String paymentDate,
			@RequestParam("discountAmmount") Double discountAmmount,
			@RequestParam("discountReason") String discountReason, ModelMap model) {
		model.put("appId", appId);
		model.put("advPay", advPay);
		model.put("dueAmt", dueAmt);
		model.put("discountAmmount", discountAmmount);
		model.put("discountReason", discountReason);
		model.put("paymentDate",
				transformTheDateFormat(paymentDate, DateTimeFormatter.ofPattern(SQL_DATE_FORMAT, Locale.ENGLISH),
						(date, format) -> LocalDate.parse(date, format)));
		return "cleardue";
	}

	@GetMapping("/cleardue")
	@ResponseBody
	public BillingAndInvoiceDto clearDlueAmount(@RequestParam("appId") Long appId,
			@RequestParam("paymentmode") String paymentmode) {
		return appointmentService.clearDlueAmount(appId, Boolean.TRUE, paymentmode);
	}
	
	@GetMapping("appointment-view-popup")
	public String appointmentViewPopUp(@RequestParam("appId") Long appId, ModelMap model) {
		model.addAttribute("appointment", appointmentService.findByAppointmentId(appId));
		return "viewappointment";
	}
	
	@PostMapping("/update-appointment-status")
	@ResponseBody
	public ResponseEntity<Integer> updateAppointmentStatus(@RequestBody AppointmentUpdateDto appointmentUpdateDto ) {
		return new ResponseEntity<>(appointmentService.updateAppointmentStatus(appointmentUpdateDto), HttpStatus.OK);
	}

}
