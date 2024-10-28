package org.example.app_a.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerService {
    private final JmsTemplate jmsTemplate;

    @Autowired
    public MessageProducerService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(String destination, String message) {
        jmsTemplate.convertAndSend(destination, message);
        System.out.println("Sent: " + message);
    }
}
