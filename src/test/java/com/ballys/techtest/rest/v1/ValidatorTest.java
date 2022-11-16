package com.ballys.techtest.rest.v1;

import com.ballys.techtest.rest.v1.exceptions.InvalidCustomerRequestException;
import com.ballys.techtest.rest.v1.request.CustomerRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    private Validator testObj;

    @BeforeEach
    void setUp() {
        testObj = new Validator();
    }

    @Test
    void validateCustomerRequest_ValidDOB_NoError() {
        CustomerRequest customerRequest = new CustomerRequest();
        customerRequest.setDob("1980-02-21");
        testObj.validateCustomerRequest(customerRequest);
    }

    @Test
    void validateCustomerRequest_InvalidDOB_InvalidCustomerRequestException() {
        CustomerRequest customerRequest = new CustomerRequest();
        customerRequest.setDob("1980-02-21234");
        assertThrows(InvalidCustomerRequestException.class, () -> testObj.validateCustomerRequest(customerRequest));
    }
}