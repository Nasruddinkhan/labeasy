package com.labeasy.enums;

/**
 * @author Nasruddin khan
 */
public enum ApplicationErrors {
    INQ_ID_NOT_FOUND("error.inquiry.id.not.found");

    /**
     * @param value
     */
    private final String value;
    ApplicationErrors(final String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
