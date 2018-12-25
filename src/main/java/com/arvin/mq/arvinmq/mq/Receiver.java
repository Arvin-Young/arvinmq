package com.arvin.mq.arvinmq.mq;

import com.arvin.mq.arvinmq.constants.ArvinConstants;
import com.arvin.mq.arvinmq.dao.RedisDao;
import com.arvin.mq.arvinmq.handle.MessageHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Receiver {
    @Autowired
    RedisDao redisDao;

    @RabbitListener(queues = ArvinConstants.ARVIN_QUEUE)
    public void mqListener(Message<String> message) {
        try {
            //handleMessage(message.getPayload());
            String player = message.getPayload();
            System.out.println(player);
            //MessageHandler.getInstance(player, 2);
            //redisDao.addBucket(player.getBytes().toString());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Async(value = "readExecutor")
    public void handleMessage(String content) throws Exception {
        Random random = new Random();
        //Thread.sleep(random.nextInt(3) * 1000);
        System.out.println(content);
    }
}
