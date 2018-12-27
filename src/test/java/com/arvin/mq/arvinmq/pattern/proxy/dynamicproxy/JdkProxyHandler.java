package com.arvin.mq.arvinmq.pattern.proxy.dynamicproxy;

import com.arvin.mq.arvinmq.pattern.proxy.staticproxy.Star;

import java.lang.reflect.Proxy;

/**
 * JDK动态代理类
 */
public class JdkProxyHandler {
    /**
     * 用来接收真实明星对象
     */
    private Object realStar;

    /**
     * 通过构造方法传进来真实的明星对象
     * @param star
     */
    public JdkProxyHandler(Star star) { this.realStar = star; }

    /**
     * 给真实对象生成一个代理对象实例
     * @return Object
     */
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(realStar.getClass().getClassLoader(),
                realStar.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("助理接单，安排剧场");
                    // 唱歌需要明星自己来唱
                    Object object = method.invoke(realStar, args);
                    System.out.println("助理结账收钱");
                    return object;
                });
    }

}
