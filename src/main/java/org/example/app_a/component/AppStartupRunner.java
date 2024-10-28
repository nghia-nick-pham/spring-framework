package org.example.app_a.component;

import org.example.app_a.service.MessageProducerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStartupRunner implements CommandLineRunner {

    private final MessageProducerService messageProducerService;

    public AppStartupRunner(MessageProducerService messageProducerService) {
        this.messageProducerService = messageProducerService;
    }

    @Override
    public void run(String... args) throws Exception {
        messageProducerService.sendMessage("my-queue", "Persistent Message Test");
    }
}
