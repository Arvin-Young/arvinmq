package com.arvin.mq.arvinmq.pattern.proxy.staticproxy;

public class ProxyStar implements Star {
    private Star star;

    ProxyStar(Star star) { this.star = star; }

    @Override
    public void sing() {
        System.out.println("助理接单安排剧场！！！！");
        star.sing();
        System.out.println("助理结账收钱！！！！");
    }
}
