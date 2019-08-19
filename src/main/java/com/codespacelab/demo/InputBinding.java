package com.codespacelab.demo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

interface InputBinding {

    String MESSAGES = "inputChannel";

    @Input(MESSAGES)
    SubscribableChannel channel();

}