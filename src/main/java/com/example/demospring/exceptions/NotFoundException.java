package com.example.demospring.exceptions;

public class NotFoundException extends RuntimeException {
    private final String code;
    private final String message;

    public NotFoundException(String code, String message) {
        this.code = code;
        this.message = message;
    }


    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
