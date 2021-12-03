package com.nixgap.douyin.open.utils;

import com.nixgap.douyin.open.utils.json.XGson;

import java.util.Map;

/**
 * HTTP请求工具
 *
 * @author Sean
 */
public class HttpUtil {

    public static String toJson(Object obj) {
        return XGson.create().toJson(obj);
    }

    public static String toForm(Object obj) {
        StringBuilder builder = new StringBuilder();
        Map<String, String> map = XGson.toMap(obj);
        map.forEach((key, val) -> {
            builder.append("&" + key + "=" + val);
        });
        return builder.substring(1);
    }
}
