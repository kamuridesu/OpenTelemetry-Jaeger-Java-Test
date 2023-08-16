
package com.kamuri.kamuriresttest.controller;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.springframework.http.ResponseEntity;

import com.kamuri.kamuriresttest.exceptions.TestException;

import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HelloControllerTest {
    @InjectMocks
    private HelloController helloController;

    @Test
    public void mustReturn200() {
        ResponseEntity<String> response = helloController.index();
        Assertions.assertTrue(response.getStatusCodeValue() == 200);
    }

    @Test
    public void mustReturnHelloWorld() {
        ResponseEntity<String> response = helloController.index();
        Assertions.assertTrue(response.getBody() == "{\"message\": \"Hello World\"}");
    }

    @Test
    public void mustThrowException() {
        Exception exception = Assertions.assertThrows(TestException.class, () -> {
            helloController.exception();
        });

        String expectedMessage = "Test Exception";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
    
}