package com.example.demospring.exceptions;

import lombok.Data;

@Data
public class MyError {
    private final String code;
    private final String message;
}
