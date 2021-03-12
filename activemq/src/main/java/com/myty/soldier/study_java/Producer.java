package com.myty.soldier.study_java;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Producer {

    @Autowired
    private JmsTemplate jmsTemplate;

    private AtomicInteger sendCount = new AtomicInteger(1);

    @Scheduled(fixedDelay = 5000)
    public void send() {
        String message = "test-counter-" + sendCount.getAndIncrement();
        // send queue to activemq
        jmsTemplate.convertAndSend("testQ", "test-counter-" + message);
        log.info("send queue : " + message);
    }

}
