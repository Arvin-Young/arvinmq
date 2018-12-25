package com.arvin.mq.arvinmq.redis;

import com.arvin.mq.arvinmq.ArvinmqApplication;
import com.arvin.mq.arvinmq.dao.RedisDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ArvinmqApplication.class)
public class TestRedis {
    @Autowired
    RedisDao redisDao;

    @Test
    public void testBatch() {
        redisDao.rbtch();
    }
}
