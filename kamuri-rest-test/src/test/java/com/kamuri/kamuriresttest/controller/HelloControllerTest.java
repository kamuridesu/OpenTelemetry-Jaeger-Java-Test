
package com.kamuri.kamuriresttest.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.springframework.http.ResponseEntity;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HelloControllerTest {
    @InjectMocks
    private HelloController helloController;

    @Test
    public void deveRetornar200() {
        ResponseEntity<String> response = helloController.index();
        Assertions.assertTrue(response.getStatusCodeValue() == 200);
    }

    @Test
    public void deveRetornarHelloWorld() {
        ResponseEntity<String> response = helloController.index();
        Assertions.assertTrue(response.getBody() == "{\"message\": \"Hello World\"}");
    }
    
}