package com.kamuri.connection.client;

import com.kamuri.connection.model.dto.MessageDTO;

public class RestTestClientMock implements RestTestClient {

    public MessageDTO getMessage() {
        MessageDTO message = new MessageDTO();
        message.setMessage("Hello World");
        return message;
    }

    public MessageDTO getException() {
        return new MessageDTO();
    }
    
}
