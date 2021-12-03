package com.nixgap.douyin.open.service.impl;

import com.nixgap.douyin.open.bean.poi.DouYinPoiSearchResult;
import com.nixgap.douyin.open.enums.DouYinApiPath;
import com.nixgap.douyin.open.exception.DouYinException;
import com.nixgap.douyin.open.service.DouYinPoiService;
import com.nixgap.douyin.open.utils.DouYinHttp;

public class DouYinPoiServiceImpl implements DouYinPoiService, DouYinHttp {
    private String client_token = null;

    public DouYinPoiServiceImpl(String clientToken) {
        this.client_token = clientToken;
    }

    @Override
    public DouYinPoiSearchResult getPoiSearchKeyword(String city, String keyword, long cursor, long count) throws DouYinException {
        String query = "access_token=%s&city=%s&keyword=%s&cursor=%s&count=%s";
        query = String.format(query, client_token, city, keyword, cursor, count);
        return this.get(DouYinApiPath.DouYin.POI_SEARCH_KEYWORD, query, DouYinPoiSearchResult.class);
    }
}
