package com.arvin.mq.arvinmq.dao;

import com.arvin.mq.arvinmq.entity.User;

public interface UserDao extends BaseDao<User> {
    User findByName(String name);
}
