package com.nixgap.douyin.open.config.impl;

import com.nixgap.douyin.open.config.DouYinClientConfigStorage;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

/**
 * 抖音应用配置
 */
public class DouYinClientConfigStorageMemory implements DouYinClientConfigStorage {

    public DouYinClientConfigStorageMemory() {
    }

    public DouYinClientConfigStorageMemory(String clientKey, String clientSecret) {
        this();
        this.clientKey = clientKey;
        this.clientSecret = clientSecret;
    }

    @Setter
    @Getter
    private String clientKey;
    @Setter
    @Getter
    private String clientSecret;
    @Setter
    @Getter
    private String accessToken;
    @Getter
    private long expiresIn;
    @Getter
    private long expiresTime;

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
        this.expiresTime = Calendar.getInstance().getTimeInMillis() + (expiresIn - 200) * 1000;
    }
}
