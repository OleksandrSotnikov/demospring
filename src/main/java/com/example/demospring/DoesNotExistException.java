package com.example.demospring;

public class DoesNotExistException extends RuntimeException {
    private final String code;
    private final String message;

    public DoesNotExistException(String code, String message) {
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
