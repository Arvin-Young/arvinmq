package com.arvin.mq.arvinmq.concurrency;

import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {

    //@Test
    public static void testThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                    System.out.println("Runnable: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }) {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                    System.out.println("Thread: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public static void testSafe() {
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(() -> {});

    }

    public static void main(String[] args) {
        testSafe();
    }
}
