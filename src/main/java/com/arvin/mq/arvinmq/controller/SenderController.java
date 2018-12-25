package com.arvin.mq.arvinmq.controller;

import com.arvin.mq.arvinmq.constants.ArvinConstants;
import com.arvin.mq.arvinmq.handle.MessageHandler;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class SenderController {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @RequestMapping("/arvinmq")
    public String sendMsgToArvinMq() {
        for (int i = 0; i < 10000; i++) {
            rabbitTemplate.convertAndSend(ArvinConstants.ARVIN_QUEUE,i + ": arvin is coming");
        }
        return "success";
    }

    @RequestMapping("/shut")
    public String shutDownPool() {
        MessageHandler.ShutExecutorPool();
        return "success";
    }
}
