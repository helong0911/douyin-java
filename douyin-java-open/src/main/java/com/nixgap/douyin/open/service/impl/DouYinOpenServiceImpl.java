package com.nixgap.douyin.open.service.impl;

import com.nixgap.douyin.open.bean.result.DouYinClientAccessToken;
import com.nixgap.douyin.open.config.DouYinCacheConfig;
import com.nixgap.douyin.open.config.DouYinClientConfigStorage;
import com.nixgap.douyin.open.enums.DouYinApiPath;
import com.nixgap.douyin.open.exception.DouYinException;
import com.nixgap.douyin.open.service.DouYinOauthService;
import com.nixgap.douyin.open.service.DouYinOpenService;
import com.nixgap.douyin.open.service.DouYinPoiService;
import com.nixgap.douyin.open.service.DouYinVideoService;
import com.nixgap.douyin.open.utils.DouYinHttp;
import org.apache.commons.lang3.StringUtils;

public class DouYinOpenServiceImpl implements DouYinOpenService, DouYinCacheConfig, DouYinHttp {
    DouYinClientConfigStorage configStorage = null;

    @Override
    public String getPlatformOauthConnect(String responseType, String scope, String optionalScope, String redirectUri, String state) {
        if (optionalScope == null) {
            optionalScope = "";
        }
        if (state == null) {
            state = "";
        }
        String url = "%s?client_key=%s&response_type=%s&scope=%s&optionalScope=%s&redirect_uri=%s&state=%s";
        url = String.format(url, DouYinApiPath.DouYin.PLATFORM_OAUTH_CONNECT, this.configStorage.getClientKey(), responseType, scope, optionalScope, redirectUri, state);
        return url;
    }

    @Override
    public String getOauthAuthorizeV2(String responseType, String scope, String redirectUri, String state) {
        if (state == null) {
            state = "";
        }
        String url = "%s?client_key=%s&response_type=%s&scope=%s&redirect_uri=%s&state=%s";
        url = String.format(url, DouYinApiPath.DouYinSNS.OAUTH_AUTHORIZE_V2, this.configStorage.getClientKey(), responseType, scope, redirectUri, state);
        return url;
    }

    @Override
    public void setClientConfigStorage(DouYinClientConfigStorage storage) {
        this.configStorage = storage;
    }

    @Override
    public DouYinClientConfigStorage getClientConfigStorage() {
        if (this.configStorage != null
            && (StringUtils.isBlank(this.configStorage.getAccessToken()) || this.configStorage.accessTokenExpired())) {
            try {
                this.updateClientAccessToken(this.configStorage, DouYinApiPath.DouYin.OAUTH_CLIENT_TOKEN);
            } catch (DouYinException e) {
                e.printStackTrace();
            }
        }
        return this.configStorage;
    }

    @Override
    public String getClientAccessToken(boolean forceRefresh) throws DouYinException {
        if (this.configStorage == null) {
            return null;
        }
        if (forceRefresh || this.configStorage.accessTokenExpired()) {
            this.updateClientAccessToken(this.configStorage, DouYinApiPath.DouYin.OAUTH_CLIENT_TOKEN);
        }
        return this.configStorage.getAccessToken();
    }

    @Override
    public DouYinOauthService getOpenOauthService() {
        return new DouYinOauthServiceImpl(this.getClientConfigStorage());
    }

    @Override
    public DouYinPoiService getDouYinPoiService() {
        try {
            return new DouYinPoiServiceImpl(this.getClientAccessToken(false));
        } catch (DouYinException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public DouYinVideoService getDouYinVideoService(String openId) {
        try {
            return new DouYinVideoServiceImpl(this.getOpenOauthService().getOauthAccessToken(openId, false));
        } catch (DouYinException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void updateClientAccessToken(DouYinClientConfigStorage storage, DouYinApiPath path) throws DouYinException {
        String data = "client_key=%s&client_secret=%s&grant_type=client_credential";
        data = String.format(data, storage.getClientKey(), storage.getClientSecret());
        DouYinClientAccessToken token = this.post(path, data, DouYinClientAccessToken.class);
        if (token != null) {
            storage.setAccessToken(token.getAccessToken());
            storage.setExpiresIn(token.getExpiresIn());
        }
    }
}
