package com.ballys.techtest.rest.v1;

import com.ballys.techtest.domain.customer.service.CustomerService;
import com.ballys.techtest.domain.customer.service.info.CustomerInfo;
import com.ballys.techtest.rest.v1.request.CustomerRequest;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class RegisterResource {
    private final CustomerService customerService;
    private final Validator validator;

    @Inject
    public RegisterResource(CustomerService customerService, Validator validator) {
        this.customerService = customerService;
        this.validator = validator;
    }

    @POST
    @Path("/register")
    public Response register(CustomerRequest customerRequest) {
        log.info("New Customer User={}", customerRequest);
        validator.validateCustomerRequest(customerRequest);
        customerService.register(new CustomerInfo());
        return Response.status(Response.Status.OK).build();
    }
}