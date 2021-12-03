package com.nixgap.douyin.open.service.impl;

import com.nixgap.douyin.open.bean.oauth.DouYinOauthAccessToken;
import com.nixgap.douyin.open.bean.video.*;
import com.nixgap.douyin.open.enums.DouYinApiPath;
import com.nixgap.douyin.open.exception.DouYinException;
import com.nixgap.douyin.open.service.DouYinVideoService;
import com.nixgap.douyin.open.utils.DouYinHttp;

import java.io.File;

public class DouYinVideoServiceImpl implements DouYinVideoService, DouYinHttp {
    DouYinOauthAccessToken accessToken = null;

    public DouYinVideoServiceImpl(DouYinOauthAccessToken accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public DouYinUploadResult imageUpload(File image) throws DouYinException {
        String url = String.format("%s?open_id=%s&access_token=%s"
            , DouYinApiPath.DouYin.IMAGE_UPLOAD
            , this.accessToken.getOpenId()
            , this.accessToken.getAccessToken()
        );
        return this.postImage(url, image, DouYinUploadResult.class);
    }

    @Override
    public DouYinCreateResult imageCreate(DouYinCreateImage image) throws DouYinException {
        String url = String.format("%s?open_id=%s&access_token=%s"
            , DouYinApiPath.DouYin.IMAGE_CREATE
            , this.accessToken.getOpenId()
            , this.accessToken.getAccessToken()
        );
        return this.postJson(url, image, DouYinCreateResult.class);
    }

    @Override
    public DouYinUploadResult videoUpload(File video) throws DouYinException {
        String url = String.format("%s?open_id=%s&access_token=%s"
            , DouYinApiPath.DouYin.VIDEO_UPLOAD
            , this.accessToken.getOpenId()
            , this.accessToken.getAccessToken()
        );
        return this.postVideo(url, video, DouYinUploadResult.class);
    }

    @Override
    public DouYinCreateResult videoCreate(DouYinCreateVideo video) throws DouYinException {
        String url = String.format("%s?open_id=%s&access_token=%s"
            , DouYinApiPath.DouYin.VIDEO_CREATE
            , this.accessToken.getOpenId()
            , this.accessToken.getAccessToken()
        );
        return this.postJson(url, video, DouYinCreateResult.class);
    }

    @Override
    public DouYinVideoSearchResult getVideoSearch(String keyword, long cursor, long count) throws DouYinException {
        String query = "open_id=%s&access_token=%s&keyword=%s&cursor=%s&count=%s";
        query = String.format(query, this.accessToken.getOpenId(), this.accessToken.getAccessToken(), keyword, cursor, count);
        return this.get(DouYinApiPath.DouYin.VIDEO_SEARCH, query, DouYinVideoSearchResult.class);
    }
}
