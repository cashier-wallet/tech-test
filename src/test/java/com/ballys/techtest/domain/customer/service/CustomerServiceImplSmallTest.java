package com.ballys.techtest.domain.customer.service;

import com.ballys.techtest.domain.customer.model.Customer;
import com.ballys.techtest.domain.customer.service.info.CustomerInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CustomerServiceImplSmallTest {
    private CustomerService testObj;

    @BeforeEach
    void setUp() {
        testObj = new CustomerServiceImpl();
    }

    @Test
    void register_ValidCustomer_Success() {
        Customer customer = testObj.register(new CustomerInfo());
        assertNotNull(customer);
    }

}