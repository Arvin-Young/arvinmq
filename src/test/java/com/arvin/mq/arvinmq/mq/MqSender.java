package com.arvin.mq.arvinmq.mq;

import com.arvin.mq.arvinmq.ArvinmqApplication;
import com.arvin.mq.arvinmq.constants.ArvinConstants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ArvinmqApplication.class)
public class MqSender {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void testMqSender() {
        for (int i = 0; i < 10000; i++) {
            rabbitTemplate.convertAndSend(ArvinConstants.ARVIN_QUEUE,i + ": arvin is coming");
        }
    }
}
