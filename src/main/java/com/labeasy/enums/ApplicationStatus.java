package com.labeasy.enums;

/**
 * @auth Nasruddin khan
 */
public enum ApplicationStatus {
    INACTIVE("N"),
    ACTIVE("Y");
    /**
     * @value
     */
    private final String value;

    ApplicationStatus(final String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
