package com.nixgap.douyin.open.config;

/**
 * 抖音缓存配置
 */
public interface DouYinCacheConfig {
    String CACHE_PREFIX = "DouYinNix";

    /**
     * 用户授权缓存KEY
     *
     * @param clientKey 应用唯一标志
     * @return
     */
    default String getCacheClientKey(String clientKey) {
        return String.format("%s:%s", this.CACHE_PREFIX, clientKey);
    }

    /**
     * 用户授权缓存KEY
     *
     * @param clientKey 应用唯一标志
     * @param openId    用户唯一标志
     * @return
     */
    default String getCacheOauthKey(String clientKey, String openId) {
        return String.format("%s:%s:%s", this.CACHE_PREFIX, clientKey, openId);
    }
}
