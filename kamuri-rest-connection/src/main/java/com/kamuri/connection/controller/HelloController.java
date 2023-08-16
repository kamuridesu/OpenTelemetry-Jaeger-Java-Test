package com.kamuri.connection.controller;

import com.kamuri.connection.client.RestTestClient;
import com.kamuri.connection.model.dto.MessageDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HelloController {

    private final RestTestClient restTestClient;

    @GetMapping("")
    public ResponseEntity<String> index() {
        MessageDTO message = restTestClient.getMessage();
        log.info(message.getMessage());
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        return ResponseEntity.ok()
                .headers(headers)
                .body("{\"receivedMessage\": \"" + message.getMessage() + "\"}");
    }

    @GetMapping("/exception")
    public ResponseEntity<String> exception() {
        MessageDTO message = restTestClient.getException();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        return ResponseEntity.ok()
                .headers(headers)
                .body("{\"receivedMessage\": \"" + message.getMessage() + "\"}");
    }

}
