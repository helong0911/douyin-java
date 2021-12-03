package com.nixgap.douyin.open.utils.http;

import com.nixgap.douyin.open.utils.json.XGson;

import java.util.Map;

/**
 * HTTP请求.
 *
 * @param <T> 返回值类型
 */
public interface RequestExecutor<E, T> {
    /**
     * 执行HTTP请求
     *
     * @param uri  uri
     * @param data 数据
     * @return 响应结果
     */
    T execute(String uri, E data, Map<String, String> header, Class<T> type) throws Exception;

    default T handleResponse(String responseContent, Class<T> type) {
        return XGson.create().fromJson(responseContent, type);
    }
}
