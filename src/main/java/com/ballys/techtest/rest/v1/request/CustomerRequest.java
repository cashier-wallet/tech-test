package com.ballys.techtest.rest.v1.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    private String username;
    private String password;
    private LocalDate dob;
    private String paymentCardNumber;
}
