package com.arvin.mq.arvinmq.pattern.proxy.staticproxy;

public class RealStar implements Star {
    @Override
    public void sing() {
        System.out.println("歌星在唱歌！！！！！");
    }
}
