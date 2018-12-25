package com.arvin.mq.arvinmq.dao;

import java.util.List;

public interface BaseDao<T> {

    void save(T t);

    List<T> findAll();
}
