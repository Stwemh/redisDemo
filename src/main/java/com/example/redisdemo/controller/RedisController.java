package com.example.redisdemo.controller;

import com.example.redisdemo.entity.User;
import com.example.redisdemo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("redis")
@EnableCaching
public class RedisController {
    @Autowired
    private RedisService redisService;

    /**
     * 设置了一个名为"userList"的缓存
     */
    @GetMapping()
    @Cacheable(cacheNames ="userList")
    public List<User> getUser(){
        System.out.println("通过有没有输出,若没有输出,代表执行了缓存,从redis中获取了数据");
        return redisService.getUser();
    }
    /**
     * 设置了一个名为"user"的缓存,同时传入的"id"设为key
     */
    @GetMapping("/{id}")
    @Cacheable(cacheNames ="User",key = "#id")
    public User getUserById(@PathVariable Long id){
        System.out.println("通过有没有输出,若没有输出,代表执行了缓存,从redis中获取了数据");
        return redisService.getUserById(id);
    }

    @PostMapping()
    @CachePut(cacheNames ="User",key = "#user.id")
    public User saveUser(User user){
        return redisService.saveUser(user);
    }
}
