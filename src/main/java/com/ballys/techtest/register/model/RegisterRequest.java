package com.ballys.techtest.register.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RegisterRequest {
    private String username;
    private char[] password;
    private LocalDate dob;
    private String paymentCardNumber;
}
