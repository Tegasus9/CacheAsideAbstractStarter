package com.tegasus9.cacheasideabstract.service.dataaccess;


import com.tegasus9.cacheasideabstract.service.serializer.IDataKeySerializer;

import java.io.IOException;

/**
 * @author Tegasus9
 * @date 2022/8/30
 * @description 数据提取服务
 */
public interface IDataWithdrawService<E,R> {

    /**
     * 获取一个数据
     * 先从缓存中获取，如果缓存中没有，则从数据库中获取，并将数据放入缓存中
     * @param dataKey
     * @param clazz
     * @return
     * @param <T>
     * @throws IOException
     */
    R getData(IDataKeySerializer<E> dataKey, Class<R> clazz) throws IOException;
}
