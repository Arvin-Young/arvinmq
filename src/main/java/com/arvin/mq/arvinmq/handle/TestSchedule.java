package com.arvin.mq.arvinmq.handle;

import com.arvin.mq.arvinmq.utils.SpringUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestSchedule {
    @Scheduled(cron = "0/2 * * * * ?")
    public void test() {
        TestSchedule testSchedule = SpringUtil.getBean(TestSchedule.class);
        System.out.println("调用方法：" + Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            testSchedule.test1();
        }
    }

    @Async("readExecutor")
    public void test1() {
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("被调用方法：" + Thread.currentThread().getName());
    }
}
