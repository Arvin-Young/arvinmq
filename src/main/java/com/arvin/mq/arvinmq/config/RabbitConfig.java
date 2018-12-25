package com.arvin.mq.arvinmq.config;

import com.arvin.mq.arvinmq.constants.ArvinConstants;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Bean
    public Queue queue() { return new Queue(ArvinConstants.ARVIN_QUEUE, true); }
}
