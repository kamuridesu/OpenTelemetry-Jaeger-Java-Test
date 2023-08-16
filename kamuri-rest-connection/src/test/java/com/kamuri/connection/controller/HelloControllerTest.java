
package com.kamuri.connection.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.http.ResponseEntity;

import com.kamuri.connection.client.RestTestClientMock;

import lombok.RequiredArgsConstructor;

import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
public class HelloControllerTest {

    private final RestTestClientMock restTestClientMock = new RestTestClientMock();

    private HelloController helloController;
    
    @BeforeEach
    public void setUp() {
        this.helloController = new HelloController(restTestClientMock);
    }

    @Test
    public void mustReturn200() {
        ResponseEntity<String> response = helloController.index();
        Assertions.assertTrue(response.getStatusCodeValue() == 200);
    }

    @Test
    public void mustReturnHelloWorld() {
        ResponseEntity<String> response = helloController.index();
        Assertions.assertEquals("{\"receivedMessage\": \"Hello World\"}", response.getBody());
    }
    
}
