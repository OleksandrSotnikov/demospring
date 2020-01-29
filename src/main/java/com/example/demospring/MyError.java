package com.example.demospring;

import lombok.Data;

@Data
public class MyError {
    private final String code;
    private final String message;
}
