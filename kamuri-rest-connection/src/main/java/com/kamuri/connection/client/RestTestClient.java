package com.kamuri.connection.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kamuri.connection.model.dto.MessageDTO;

@FeignClient(value="client", url="${kamurest.url}")
public interface RestTestClient {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    MessageDTO getMessage();

    @RequestMapping(method = RequestMethod.GET, value = "/exception")
    MessageDTO getException();
    
}
