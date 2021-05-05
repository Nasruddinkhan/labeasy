package com.labeasy.eception;


/**
 * @author Nasruddin
 */
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = -2160551017003215935L;

    /**
     *
     * @param msg
     */
    public NotFoundException(final String msg) {
        super(msg);
    }
}
