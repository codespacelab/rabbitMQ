package com.codespacelab.demo;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(InputBinding.class)
public class DemoListener {

    @StreamListener(target = InputBinding.MESSAGES)
    public void processHelloChannelGreeting(String msg) {
        System.out.println(msg);
    }
}
