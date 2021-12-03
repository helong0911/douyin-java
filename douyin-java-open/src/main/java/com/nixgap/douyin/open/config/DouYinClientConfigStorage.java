package com.nixgap.douyin.open.config;

import java.util.Calendar;

/**
 * 抖音应用配置
 */
public interface DouYinClientConfigStorage {
    /**
     * Set client key
     */
    void setClientKey(String clientKey);

    /**
     * Get client key
     */
    String getClientKey();

    /**
     * Set client secret
     */
    void setClientSecret(String clientSecret);

    /**
     * Get client secret
     */
    String getClientSecret();

    /**
     * Set access token
     */
    void setAccessToken(String accessToken);

    /**
     * Get access token
     */
    String getAccessToken();

    /**
     * Set expires in
     */
    void setExpiresIn(long expiresIn);

    /**
     * Get expires in
     */
    long getExpiresIn();

    /**
     * Get expires time
     */
    long getExpiresTime();

    /**
     * Access token is expired
     */
    default boolean accessTokenExpired() {
        return Calendar.getInstance().getTimeInMillis() > this.getExpiresTime();
    }
}
