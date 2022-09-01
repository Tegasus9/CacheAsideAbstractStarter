package com.tegasus9.cacheasideabstract.service.key;


import com.tegasus9.cacheasideabstract.service.serializer.IDataKeySerializer;

/**
 * @author Tegasus9
 * @date 2022/8/30
 * @description 一个Factory用来获取redisKey
 */
public enum RedisKeyFactory {
    X;
    /**
     * 获取一个RedisKey字符串。
     * 格式为：${serviceKeyPrefix}:${abilityKeyPrefix}:${keyString}
     * @param serviceKey
     * @param abilityKey
     * @param keyString
     * @return
     */
    public String from(IServiceKeyPrefix serviceKey, IAbilityKeyPrefix abilityKey, String keyString) {
        return serviceKey.getKeyString() + ":" + abilityKey.getKeyString() + ":" + keyString;
    }

    public String from(IDataKeySerializer<?> IDataKeySerializer) {
        return IDataKeySerializer.serializeToRedisKey();
    }
}
