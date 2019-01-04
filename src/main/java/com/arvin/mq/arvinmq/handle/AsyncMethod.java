package com.arvin.mq.arvinmq.handle;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncMethod {

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
