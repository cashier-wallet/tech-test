package com.ballys.techtest.application;

import com.ballys.techtest.configuration.ApplicationConfig;
import com.ballys.techtest.configuration.ExceptionHandlers;
import com.ballys.techtest.configuration.JerseyConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;

@Slf4j
@Import({
        ApplicationConfig.class,
        JerseyConfig.class,
        ExceptionHandlers.class
})
@EnableAutoConfiguration
public class RegisterApplication {

    public RegisterApplication() {
        log.info("Register APP INITIALISED version={}", getClass().getPackage().getImplementationVersion());
    }

    public static void main(String[] args) {
        SpringApplication.run(RegisterApplication.class, args);
    }
}
