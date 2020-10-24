package com.example.redisdemo.service;

import com.example.redisdemo.entity.User;

import java.util.List;

/**
 * @author TangZongHua
 * @date 2020/10/22
 * @description:
 */
public interface RedisService {
    List<User> getUser();

    User getUserById(Long id);

    User saveUser(User user);
}
