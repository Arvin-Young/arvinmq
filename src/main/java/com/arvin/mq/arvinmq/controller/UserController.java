package com.arvin.mq.arvinmq.controller;

import com.arvin.mq.arvinmq.dao.UserDao;
import com.arvin.mq.arvinmq.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserDao userDao;

    @RequestMapping("/save")
    public String save() {
        User user = new User();
        user.setName("danlan");
        user.setAge(18);
        userDao.save(user);
        return "success";
    }

    @RequestMapping("/all")
    public List<User> findAllUser() {
        return userDao.findAll();
    }
}
