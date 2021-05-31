package com.labeasy;

import static com.labeasy.utils.CommonUtils.transformTheDateFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.labeasy.utils.CommonUtils;

public class Test {
	public static void main(String[] args) {
		/*
		 * DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		 * String date = inputFormat.format("2021-05-30T18:05:01");
		 * System.out.println(date);
		 */
		
		String date = "2021-05-30T18:05:01";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
		
		LocalDate date1 =  CommonUtils.transformTheDateFormat(date, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH), (string, format)-> LocalDate.parse(string, formatter));
		
	}
	
	private LocalDate getAppointmentDate(String appointmentDate) {
		return transformTheDateFormat(appointmentDate, DateTimeFormatter.ISO_DATE,
				(date, format) -> LocalDate.parse(date, format));
	}
}
