package com.arvin.mq.arvinmq.handle;

import java.util.concurrent.*;

public class MessageHandler {
    private int times = 0;

    private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

    //private static MessageHandler messageHandler;

    public static MessageHandler getInstance(String player, int period) {
        return new MessageHandler(player, period);
    }

    public MessageHandler(String player, int period) {
        if (executorService == null || executorService.isTerminated()) {
            executorService = Executors.newScheduledThreadPool(5);
        }
        executorService.scheduleAtFixedRate(() -> {
            times++;
            System.out.println(Thread.currentThread().getName() + ": " + player + " Heja BVB " + times + " time!");
        }, 5, period, TimeUnit.SECONDS);
    }

    public static void ShutExecutorPool() {
        executorService.shutdown();
    }
}
