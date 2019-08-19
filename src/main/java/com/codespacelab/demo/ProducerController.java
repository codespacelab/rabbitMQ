package com.codespacelab.demo;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    private MessageChannel messages;

    public ProducerController(OutputBinding binding) {
        messages = binding.channel();
    }

    @GetMapping("/messages/{number}")
    public String publish(@PathVariable int number) {
        for(int i = 1; i < number; i++) {
            Message<String> msg = MessageBuilder.withPayload("Event number: " + i)
                    .build();
            messages.send(msg);
        }

        return "Finished";
    }

}
