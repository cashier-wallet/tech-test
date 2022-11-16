package com.ballys.techtest.rest.v1;

import com.ballys.techtest.rest.v1.exceptions.InvalidCustomerRequestException;
import com.ballys.techtest.rest.v1.request.CustomerRequest;
import lombok.extern.slf4j.Slf4j;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Slf4j
public class Validator {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public void validateCustomerRequest(CustomerRequest customerRequest) {
        try{
            DATE_TIME_FORMATTER.parse(customerRequest.getDob());
        } catch (DateTimeParseException dateTimeParseException) {
            throw new InvalidCustomerRequestException("invalid.dob.request", "Invalid DOB. Needs to be in the format of yyyy-MM-dd");
        }
    }
}
