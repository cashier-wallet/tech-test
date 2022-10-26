package com.ballys.techtest.rest.v1.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ErrorListResponse {

    private final List<ErrorResponse> errors = new ArrayList<>();

    public ErrorListResponse(Object code, String message) {
        errors.add(new ErrorResponse(code, message));
    }

    public ErrorListResponse(List<ErrorResponse> errors) {
        this.errors.addAll(errors);
    }

    @Getter
    @AllArgsConstructor
    public static class ErrorResponse {
        private final Object code;
        private final String message;
    }
}
