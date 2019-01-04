package com.arvin.mq.arvinmq;

import com.arvin.mq.arvinmq.utils.SpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ArvinmqApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(ArvinmqApplication.class, args);
		SpringUtil.setApplicationContext(applicationContext);
	}

}

