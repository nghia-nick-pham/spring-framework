package org.example.app_a;

import org.example.app_a.service.MessageProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProjectApplication implements CommandLineRunner {

    private final MessageProducerService messageProducerService;

    @Autowired
    public SpringBootProjectApplication(MessageProducerService messageProducerService) {
        this.messageProducerService = messageProducerService;
    }

    @Override
    public void run(String... args) {
        messageProducerService.sendMessage("my-queue", "Persistent Message Test");
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringBootProjectApplication.class, args);
    }
}
