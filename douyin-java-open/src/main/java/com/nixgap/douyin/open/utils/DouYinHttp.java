package com.nixgap.douyin.open.utils;

import com.nixgap.douyin.open.bean.DouYinError;
import com.nixgap.douyin.open.bean.DouYinResponse;
import com.nixgap.douyin.open.enums.DouYinApiPath;
import com.nixgap.douyin.open.exception.DouYinException;
import com.nixgap.douyin.open.utils.http.RequestExecutor;
import com.nixgap.douyin.open.utils.http.jodd.JoddFileRequestExecutor;
import com.nixgap.douyin.open.utils.http.jodd.JoddGetRequestExecutor;
import com.nixgap.douyin.open.utils.http.jodd.JoddPostRequestExecutor;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 抖音服务调用实现
 *
 * @author Sean
 */
public interface DouYinHttp {
    String APPLICATION_FORM = "application/x-www-form-urlencoded";
    String APPLICATION_JSON = "application/json";

    default <T> T get(DouYinApiPath path, String query, Class<T> type) throws DouYinException {
        return this.get(path.getUrl(), query, type);
    }

    default <T> T get(String url, String query, Class<T> type) throws DouYinException {
        RequestExecutor<String, DouYinResponse> executor = new JoddGetRequestExecutor<>();
        return this.request(executor, url, query, null, type);
    }

    default <E, T> T postJson(DouYinApiPath path, E data, Class<T> type) throws DouYinException {
        return this.postJson(path.getUrl(), data, type);
    }

    default <E, T> T postJson(String path, E data, Class<T> type) throws DouYinException {
        String json = HttpUtil.toJson(data);
        return this.post(path, json, this.APPLICATION_JSON, type);
    }

    default <T> T postVideo(String path, File data, Class<T> type) throws DouYinException {
        Map<String, Object> map = new HashMap<>();
        map.put("Content-Type", "video/mp4");
        map.put("video", data);
        return this.postFile(path, map, type);
    }

    default <T> T postImage(String path, File data, Class<T> type) throws DouYinException {
        Map<String, Object> map = new HashMap<>();
        map.put("image", data);
        return this.postFile(path, map, type);
    }

    default <T> T postFile(String path, Map<String, Object> data, Class<T> type) throws DouYinException {
        RequestExecutor<Map<String, Object>, DouYinResponse> executor = new JoddFileRequestExecutor<>();
        return this.request(executor, path, data, null, type);
    }

    default <E, T> T post(DouYinApiPath path, E data, Class<T> type) throws DouYinException {
        return this.post(path, HttpUtil.toForm(data), type);
    }

    default <T> T post(DouYinApiPath path, String data, Class<T> type) throws DouYinException {
        return this.post(path.getUrl(), data, this.APPLICATION_FORM, type);
    }

    default <T> T post(String url, String data, String contentType, Class<T> type) throws DouYinException {
        Map<String, String> head = new HashMap<>();
        head.put("Content-Type", contentType);
        RequestExecutor<String, DouYinResponse> executor = new JoddPostRequestExecutor<>();
        return this.request(executor, url, data, head, type);
    }

    /**
     * @param executor HTTP操作对象
     * @param url      请求地址
     * @param data     请求参数
     * @param head     header头
     * @param type     泛型T类型
     * @param <E>      请求参数类型
     * @param <T>      返回参数类型
     * @return
     * @throws DouYinException
     */
    default <E, T> T request(RequestExecutor<E, DouYinResponse> executor, String url, E data, Map<String, String> head, Class<T> type) throws DouYinException {
        DouYinResponse response = null;
        try {
            response = executor.execute(url, data, head, DouYinResponse.class);
            if (response.getData() == null && response.getExtra() == null) {
                return null;
            }
            T result = null;
            if (response.getData() != null) {
                result = response.getData(type);
            }
            // 如果存在ERROR对象，则验证该对象ERROR_CODE
            if (response.getExtra() != null && StringUtils.equalsAny(response.getExtra().getErrorCode(), null, "0")) {
                return result;
            }
            // 如果T对象不为空，同时继承自DouYinErrorCode，则验证该对象ERROR_CODE
            // 否则，直接返回T对象
            if (result != null && result instanceof DouYinError) {
                DouYinError error = (DouYinError) result;
                if (StringUtils.equalsAny(error.getErrorCode(), null, "0")) {
                    return result;
                }
            } else {
                return result;
            }
        } catch (Exception e) {
            throw new DouYinException("500", e);
        }
        throw new DouYinException(response.getExtra().getErrorCode(), response.getExtra().getDescription());
    }
}
