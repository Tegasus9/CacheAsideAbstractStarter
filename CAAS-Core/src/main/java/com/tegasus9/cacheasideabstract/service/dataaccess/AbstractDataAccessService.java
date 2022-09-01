package com.tegasus9.cacheasideabstract.service.dataaccess;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tegasus9.cacheasideabstract.service.cache.ICacheService;
import com.tegasus9.cacheasideabstract.service.serializer.IDataKeySerializer;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.Duration;

/**
 * @author Tegasus9
 * @date 2022/8/30
 * @description
 */
public abstract class AbstractDataAccessService<E, R> implements IDataWithdrawService<E, R> {
    @Resource
    protected ICacheService cacheService;
    @Resource
    protected ObjectMapper objectMapper;

    @Override
    public R getData(IDataKeySerializer<E> dataKey, Class<R> clazz) throws IOException {
        String jsonString = cacheService.get(dataKey.serializeToRedisKey());
        R data = null;
        if (jsonString == null) {
            try {
                data = getDataFromDB(dataKey);
                return data;
            } finally {
                cacheService.set(dataKey.serializeToRedisKey(), objectMapper.writeValueAsString(data), getDuration());
            }
        }
        return objectMapper.readValue(jsonString, clazz);
    }

    /**
     * 默认存储时间为1天
     *
     * @return
     */
    protected Duration getDuration() {
        return Duration.ofDays(1);
    }

    /**
     * 从数据库中获取数据
     *
     * @param keyData
     * @return
     */
    protected abstract R getDataFromDB(IDataKeySerializer<E> keyData);

}
