package com.tegasus9.cacheasideabstract.service.cache.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tegasus9.cacheasideabstract.service.cache.ICacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author Tegasus9
 * @date 2022/8/25
 * @description redis缓存实现类
 */
@Slf4j
public class DefaultRedisServiceImpl implements ICacheService {
    private final RedisTemplate<String,Object> redisTemplate;
    private final ObjectMapper objectMapper;

    public DefaultRedisServiceImpl(RedisTemplate<String, Object> redisTemplate, ObjectMapper objectMapper) {
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public String get(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

    @Override
    public <T> T get(String key, Class<T> clazz) throws IOException {
        String jsonString = get(key);
        if (jsonString == null) {
            return null;
        }
        return objectMapper.readValue(jsonString, clazz);
    }

    @Override
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key,value);
    }

    @Override
    public void set(String key, String value, Duration duration) {
        redisTemplate.opsForValue().set(key,value,duration);
    }

    @Override
    public void set(String key, String value, long expireTime, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key,value,expireTime,timeUnit);
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }
}
