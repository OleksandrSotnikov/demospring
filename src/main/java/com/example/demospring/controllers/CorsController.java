package com.example.demospring.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CorsController {

    @RequestMapping(method = RequestMethod.OPTIONS, path = "/**")
    public ResponseEntity<String> options(@RequestHeader("origin") String origin) {
        String allowedMethods = "GET, POST, DELETE, PUT, HEAD, OPTIONS";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Access-Control-Allow-Origin", origin);
        httpHeaders.add("Access-Control-Allow-Methods", allowedMethods);

        return ResponseEntity.ok().headers(httpHeaders).body(allowedMethods);

    }
}
