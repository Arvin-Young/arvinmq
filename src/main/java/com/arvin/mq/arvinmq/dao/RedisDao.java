package com.arvin.mq.arvinmq.dao;

import org.redisson.api.RBatch;
import org.redisson.api.RBucket;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class RedisDao<T> {
    @Autowired
    RedissonClient redissonClient;

    public void addBucket(String key, T t) {
        RBucket<T> bucket = redissonClient.getBucket(key);
        bucket.set(t, 5, TimeUnit.HOURS);
    }

    public T getBucket(String key) {
        RBucket<String> bucket = redissonClient.getBucket(key);
        return (T) bucket.get();
    }

    public void addList(String key, T t) {
        RList<T> list = redissonClient.getList(key);
        list.add(t);
    }

    public List<T> getList(String key) {
        RList<T> list = redissonClient.getList(key);
        return list.readAll();
    }

    public void rbtch() {
        RBatch batch = redissonClient.createBatch();
        batch.getMap("test").fastPutAsync("1", "2");
        batch.getMap("test").fastPutAsync("2", "3");
        batch.getMap("test").putAsync("2", "5");
        batch.getAtomicLong("counter").incrementAndGetAsync();
        batch.getAtomicLong("counter").incrementAndGetAsync();
        List<?> res = batch.execute();
        res.forEach(e -> {
            System.out.println(e);
        });
    }
}
