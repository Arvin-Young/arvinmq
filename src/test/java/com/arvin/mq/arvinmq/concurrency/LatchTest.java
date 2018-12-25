package com.arvin.mq.arvinmq.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class LatchTest {
    //private int iCounter = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable taskTemp = new Runnable() {
            //private AtomicInteger iCounter = new AtomicInteger(0);
            private int iCounter;
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    iCounter++;
                    //iCounter.getAndIncrement();
                    System.out.println(System.nanoTime() + " [" + Thread.currentThread().getName() + "] iCounter = " + iCounter);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        LatchTest latchTest = new LatchTest();
        latchTest.startAllTasksInOnce(5, taskTemp);
    }

    public long startAllTasksInOnce(int threadNum, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(threadNum);
        for (int i= 0; i < threadNum; i++) {
            new Thread(() -> {
                try {
                    // 使线程在此等待，当开始门打开时，一起涌入门中
                    startGate.await();
                    try {
                        task.run();
                    } finally {
                        // 将结束门减1，减到0时，就可以开启结束门了
                        endGate.countDown();
                    }
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }).start();
        }
        long startTime = System.currentTimeMillis();
        System.out.println(startTime + " [" + Thread.currentThread() + "] All thread is ready, concurrent going...");
        // 因开启门只需一个开关，所以立马就开启开始门
        startGate.countDown();
        // 等等结束门开启
        endGate.await();
        long endTime = System.nanoTime();
        System.out.println(endTime + " [" + Thread.currentThread() + "] All thread is completed.");
        return endTime - startTime;
    }
}

