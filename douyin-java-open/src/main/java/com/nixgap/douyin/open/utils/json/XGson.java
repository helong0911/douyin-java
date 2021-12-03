package com.nixgap.douyin.open.utils.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.util.Map;

public class XGson {
    private static final GsonBuilder INSTANCE = new GsonBuilder();

    static {
        INSTANCE.disableHtmlEscaping();
    }

    public static JsonElement toJsonElement(Object src) {
        return INSTANCE.create().toJsonTree(src);
    }

    public static Map<String, String> toMap(Object src) {
        Gson gson = INSTANCE.create();
        return gson.fromJson(gson.toJson(src), new TypeToken<Map<String, String>>() {
        }.getType());
    }

    public static Gson create() {
        return INSTANCE.create();
    }
}
