package com.arvin.mq.arvinmq.pattern.proxy.dynamicproxy;

import com.arvin.mq.arvinmq.pattern.proxy.staticproxy.RealStar;
import com.arvin.mq.arvinmq.pattern.proxy.staticproxy.Star;
import org.junit.Test;

public class DynamicProxyTest {

    @Test
    public void testJdk() {
        Star star = new RealStar();

        Star proxyStar = (Star) new JdkProxyHandler(star).getProxyInstance();
        proxyStar.sing();
    }

    @Test
    public void testCglib() {
        Star star = new RealStar();

        Star proxyStar = (Star) new CglibProxyHandler().getProxyInstance(star);
        proxyStar.sing();
    }
}
