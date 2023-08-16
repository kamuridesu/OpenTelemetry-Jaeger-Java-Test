package com.kamuri.kamuriresttest.controller;

import com.kamuri.kamuriresttest.exceptions.TestException;
import com.kamuri.kamuriresttest.model.HelloWorld;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @GetMapping("")
    public Map<String, String> index() {
        return HelloWorld.getHelloWorld();
    }
    
    @GetMapping("/exception")
    public ResponseEntity<String> exception() throws TestException {
        throw new TestException("Test Exception");
    }

}
