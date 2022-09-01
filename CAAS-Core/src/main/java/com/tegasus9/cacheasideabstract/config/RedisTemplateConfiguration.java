package com.tegasus9.cacheasideabstract.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tegasus9.cacheasideabstract.service.cache.ICacheService;
import com.tegasus9.cacheasideabstract.service.cache.impl.DefaultRedisServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author Tegasus9
 * @date 2022/8/25
 * @description
 */
@Configuration
//@ConditionalOnProperty(prefix = "spring.redis",name="host")
public class RedisTemplateConfiguration {
    @Bean(name = "redisService")
    @SuppressWarnings("all")
    public ICacheService redisService(RedisTemplate redisTemplate, ObjectMapper objectMapper) {

        return new DefaultRedisServiceImpl(redisTemplate,objectMapper);
    }
    @Bean
    @SuppressWarnings("all")
    public RedisTemplate redisTemplateInit(RedisTemplate redisTemplate) {

        //设置序列化Key的实例化对象
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置序列化Value的实例化对象
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }
}
