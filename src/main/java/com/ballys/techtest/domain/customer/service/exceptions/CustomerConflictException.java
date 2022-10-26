package com.ballys.techtest.domain.customer.service.exceptions;

public class CustomerConflictException extends RuntimeException {
    public CustomerConflictException(String msg) {
        super(msg);
    }
}
