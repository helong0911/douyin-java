package com.nixgap.douyin.open.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@AllArgsConstructor
@Getter
public enum DouYinApiHost {
    /**
     * 抖音
     */
    DOUYIN("https://open.douyin.com"),
    /**
     * 抖音SNS
     */
    DOUYINSNS("https://aweme.snssdk.com"),
    /**
     * 头条
     */
    TOUTIAO("https://open.snssdk.com"),
    /**
     * 西瓜
     */
    XIGUA("https://open-api.ixigua.com");

    private final String host;

    /**
     * 生成完整API地址
     *
     * @param path
     * @return
     */
    public String buildUrl(String path) {
        if (StringUtils.isAllBlank(this.getHost(), path)) {
            return null;
        }
        return this.getHost() + path;
    }
}
