package com.ballys.techtest.configuration;

import com.ballys.techtest.domain.customer.service.CustomerService;
import com.ballys.techtest.domain.customer.service.CustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public CustomerService customerService() {
        return new CustomerServiceImpl();
    }

}
