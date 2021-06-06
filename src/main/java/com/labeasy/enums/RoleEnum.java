package com.labeasy.enums;

public enum RoleEnum {

	PHLEBOTOMIST("Phlebotomist");
	private final String value;

	RoleEnum(final String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
