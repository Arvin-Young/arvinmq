package com.arvin.mq.arvinmq.concurrency;

public class ThreadSafe {
    public static void main(String[] args) {
        new ThreadSafe().init();
    }

    public void init() {
        OutPuter outPuter = new OutPuter();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(5);
                    outPuter.output("李嘉欣");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(() -> {
                try {
                    Thread.sleep(5);
                    outPuter.output("钟楚红");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}

class OutPuter {
    public void output(String target) {
        synchronized (this) {
            for (int i = 0; i < target.length(); i++) {
                System.out.print(target.charAt(i));
            }
            System.out.println();
        }
    }
}
