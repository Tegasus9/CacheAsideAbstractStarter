package com.tegasus9.cacheasideabstract.service.key;

/**
 * @author Tegasus9
 * @date 2022/8/30
 * @description 标识这是这一个redisKey前缀
 */
public interface IRedisKeyPrefix {
    /**
     * 获取一个RedisKey字符串。
     * @return
     */
    String getKeyString();
}
