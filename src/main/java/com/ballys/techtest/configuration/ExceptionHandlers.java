package com.ballys.techtest.configuration;

import com.ballys.techtest.domain.customer.service.exceptions.CustomerConflictException;
import com.ballys.techtest.rest.v1.exceptions.InvalidCustomerRequestException;
import com.ballys.techtest.rest.v1.response.ErrorListResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Configuration
public class ExceptionHandlers {
    public ExceptionHandlers() {
    }

    @Provider
    @Component
    public static class CustomerConflictExceptionMapper implements ExceptionMapper<CustomerConflictException> {

        @Override
        public Response toResponse(CustomerConflictException exception) {
            return Response.status(Response.Status.CONFLICT)
                    .entity(new ErrorListResponse("customer already exists", exception.getMessage()))
                    .build();
        }
    }

    @Provider
    @Component
    public static class InvalidCustomerRequestExceptionMapper implements ExceptionMapper<InvalidCustomerRequestException> {

        @Override
        public Response toResponse(InvalidCustomerRequestException exception) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorListResponse(exception.getErrorCode(), exception.getMessage()))
                    .build();
        }
    }
}
