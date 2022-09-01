package com.tegasus9.cacheasideabstract.service.serializer;

/**
 * @author Tegasus9
 * @date 2022/8/30
 * @description RedisKey序列化器
 */
public interface IDataKeySerializer<T> {
    /**
     * 序列化为字符串
     * @return
     */
    String serializeToRedisKey();

    /**
     * 序列化前对象
     * @return
     */
    T data();
}
