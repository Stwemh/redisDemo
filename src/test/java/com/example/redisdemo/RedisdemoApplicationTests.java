package com.example.redisdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisdemoApplicationTests {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    void testGetCache() {
        // 添加redis缓存
        redisTemplate.opsForValue().set("testRedis", "hello redis!");
    }
    @Test
    void testSetCache() {
        // 读取redis缓存
        String testRedis = redisTemplate.opsForValue().get("testRedis");
        System.out.println(testRedis);
    }
}
