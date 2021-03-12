package com.myty.soldier.study_java;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Receiver {

    @JmsListener(destination = "testQ", containerFactory = "mqFactory")
    public void receive(String queue) throws InterruptedException {
        log.info("Queue message : " + queue);
        Thread.sleep(1000);
    }

}
