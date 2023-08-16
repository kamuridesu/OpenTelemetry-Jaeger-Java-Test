package com.kamuri.kamuriresttest.controller;

import com.kamuri.kamuriresttest.exceptions.TestException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @GetMapping("")
    public ResponseEntity<String> index() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        return ResponseEntity.ok()
            .headers(headers)
            .body("{\"message\": \"Hello World\"}");
    }
    
    @GetMapping("/exception")
    public ResponseEntity<String> exception() throws TestException {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        throw new TestException("Test Exception");
    }

}
