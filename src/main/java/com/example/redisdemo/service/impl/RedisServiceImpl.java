package com.example.redisdemo.service.impl;

import com.example.redisdemo.dao.UserDao;
import com.example.redisdemo.entity.User;
import com.example.redisdemo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author TangZongHua
 * @date 2020/10/22
 * @description:
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> getUser() {
        // 查询所有user
        return userDao.findAll();
    }

    @Override
    public User getUserById(Long id) {
        // 通过id查询user
        Optional<User> userOptional = userDao.findById(id);
        // 如果查询的结果为null,返回null
        return userOptional.orElse(null);
    }

    @Override
    public User saveUser(User user) {
        // 如果user中id在表中已经存在,则是更新,若不存在,则是添加.
        return userDao.save(user);
    }
}
