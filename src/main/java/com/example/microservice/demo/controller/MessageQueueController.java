package com.example.microservice.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@RestController
@RequestMapping("/queue")
public class MessageQueueController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @GetMapping("/queue1")
    public String sendMessage() {
        jmsMessagingTemplate.convertAndSend(queue,"data...");
        return "success";
    }

    /**
     * 测试收到消息
     * @param payload
     */
    @JmsListener(destination = "queue1")
    public void receiveMessage(String payload) {
        System.out.println(payload);
    }
}
