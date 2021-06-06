package com.labeasy.enums;

public enum AppointmentStatus {
	
	NEWLY_CREATED_APPOINTMENT("NW"),
	ASSIGNED_TO_PHLEBO("AP"),
	CUSTOMER_TRACK("CT"),
	SAMPLE_COLLECTED("SC"),
	SAMPLE_DROPPED("SD"), 
	SAMPLE_UNDER_PROCESS("SP"), 
	SAMPLE_PROCESSED_TESTED("SE"),
	REPORT_DISPATCHED("RD");

	private final String value;

	AppointmentStatus(final String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
