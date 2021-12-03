package com.nixgap.douyin.open.utils.http.jodd;

import com.nixgap.douyin.open.utils.http.RequestExecutor;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

import java.nio.charset.StandardCharsets;
import java.util.Map;

public class JoddGetRequestExecutor<T> implements RequestExecutor<String, T> {
    @Override
    public T execute(String uri, String query, Map<String, String> header, Class<T> type) {
        HttpRequest request = HttpRequest.get(uri);
        if (header != null) {
            request.header(header);
        }
        if (query != null) {
            request.queryString(query);
        }
        HttpResponse response = request.send();
        response.charset(StandardCharsets.UTF_8.name());
        return this.handleResponse(response.bodyText(), type);
    }
}
