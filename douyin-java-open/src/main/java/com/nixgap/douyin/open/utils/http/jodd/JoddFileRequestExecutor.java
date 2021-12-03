package com.nixgap.douyin.open.utils.http.jodd;

import com.nixgap.douyin.open.utils.http.RequestExecutor;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

import java.nio.charset.StandardCharsets;
import java.util.Map;

public class JoddFileRequestExecutor<T> implements RequestExecutor<Map<String, Object>, T> {
    @Override
    public T execute(String uri, Map<String, Object> data, Map<String, String> header, Class<T> type) {
        HttpRequest request = HttpRequest.post(uri);
        if (header != null) {
            request.header(header);
        }
        if (data != null) {
            request.form(data);
        }
        HttpResponse response = request.send();
        response.charset(StandardCharsets.UTF_8.name());
        return this.handleResponse(response.bodyText(), type);
    }
}
