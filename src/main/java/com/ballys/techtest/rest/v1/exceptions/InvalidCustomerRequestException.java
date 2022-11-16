package com.ballys.techtest.rest.v1.exceptions;

public class InvalidCustomerRequestException extends RuntimeException {
    private String errorCode;

    public InvalidCustomerRequestException(String errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }


}
