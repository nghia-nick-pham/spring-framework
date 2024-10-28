package org.example.app_a.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @JmsListener(destination = "my-queue")
    public void receiveMessage(String message) {
        System.out.println("Received: " + message);
    }
}
