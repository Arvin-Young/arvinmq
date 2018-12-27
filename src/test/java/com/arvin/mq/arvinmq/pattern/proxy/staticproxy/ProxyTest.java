package com.arvin.mq.arvinmq.pattern.proxy.staticproxy;

import org.junit.Test;

public class ProxyTest {

    @Test
    public void test() {
        Star star = new RealStar();
        ProxyStar proxyStar = new ProxyStar(star);

        proxyStar.sing();
    }
}
