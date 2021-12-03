package com.nixgap.douyin.open.bean;

import com.google.gson.JsonElement;
import com.nixgap.douyin.open.utils.json.XGson;
import lombok.Data;

/**
 * 抖音返回信息
 */
@Data
public class DouYinResponse {
    private String message;
    private DouYinResponseExtra extra;
    private JsonElement data;

    public <T> T getData(Class<T> type) {
        return XGson.create().fromJson(this.data, type);
    }
}
