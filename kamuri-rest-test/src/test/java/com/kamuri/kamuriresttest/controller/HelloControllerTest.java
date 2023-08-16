
package com.kamuri.kamuriresttest.controller;

import org.junit.jupiter.api.Test;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;

import com.kamuri.kamuriresttest.exceptions.TestException;
import com.kamuri.kamuriresttest.model.HelloWorld;

import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HelloControllerTest {
    @InjectMocks
    private HelloController helloController;

    @Test
    public void mustReturn200() {
        Map<String, String> response = helloController.index();
        Assertions.assertTrue(response.containsKey("message"));
    }

    @Test
    public void mustReturnHelloWorld() {
        Map<String, String> response = helloController.index();
        Assertions.assertEquals(response, HelloWorld.getHelloWorld());
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