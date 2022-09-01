package com.tegasus9.cacheasideabstract.service.cache;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author Tegasus9
 * @date 2022/8/25
 * @description 缓存服务
 */
public interface ICacheService {
    /**
     * @param key
     * @return
     * @description 获取缓存中的值
     */
    String get(String key);
    /**
     * @param key
     * @return <T>
     * @description 获取缓存中的值并转换成指定类型
     */
    <T> T get(String key, Class<T> clazz) throws IOException;
    /**
     * @param key
     * @param value
     * @description 存储值到缓存中
     */
    void set(String key, String value);

    /**
     * setKey
     * @param key
     * @param value
     * @param duration
     */
    void set(String key, String value, Duration duration);
    /**
     * @param key
     * @param value
     * @param expireTime
     * @param timeUnit
     * @description 存储值到缓存中，并设置过期时间
     */
    void set(String key, String value, long expireTime, TimeUnit timeUnit);
    /**
     * @param key
     * @description 删除缓存中的值
     */
    void delete(String key);
}
