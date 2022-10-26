package com.ballys.techtest.rest.v1;

import com.ballys.techtest.application.RegisterApplication;
import com.ballys.techtest.rest.v1.request.CustomerRequest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = {RegisterApplication.class})
class RegisterResourceMediumTest {
    @LocalServerPort private int serverPort;

    @BeforeEach
    public void setUp() {
        RestAssured.port = serverPort;
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void testHealthCheck() {
        given().log().all()
                .contentType(JSON)
                .when()
                .get("/tech-test-api/health")
                .then().log().all()
                .assertThat().statusCode(200).contentType(JSON)
                .assertThat().body(notNullValue())
                .assertThat().body("status", equalTo("UP"));
    }

    @Test
    public void testInfo() {
        given().log().all()
                .contentType(JSON)
                .when()
                .get("/tech-test-api/info")
                .then().log().all()
                .assertThat().statusCode(200).contentType(JSON);
    }

    @Test
    public void register_ValidCustomer_Return201SuccessResponse() {
        CustomerRequest customerRequest = new CustomerRequest("BobFrench", "Password1", LocalDate.parse("1980-02-21"), "349293081054422");
        given().log().all()
                .contentType(JSON)
                .body(customerRequest)
                .when()
                .post("/tech-test-api/v1/register")
                .then().log().all()
                .assertThat().statusCode(201).contentType(JSON);
    }

}