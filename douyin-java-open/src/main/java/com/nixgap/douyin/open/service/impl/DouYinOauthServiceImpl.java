package com.nixgap.douyin.open.service.impl;

import com.nixgap.douyin.open.bean.oauth.DouYinOauthAccessToken;
import com.nixgap.douyin.open.bean.oauth.DouYinOauthUserInfo;
import com.nixgap.douyin.open.bean.oauth.DouYinRenewRefreshToken;
import com.nixgap.douyin.open.config.DouYinCacheConfig;
import com.nixgap.douyin.open.config.DouYinClientConfigStorage;
import com.nixgap.douyin.open.enums.DouYinApiPath;
import com.nixgap.douyin.open.exception.DouYinException;
import com.nixgap.douyin.open.service.DouYinOauthService;
import com.nixgap.douyin.open.utils.DouYinHttp;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DouYinOauthServiceImpl implements DouYinOauthService, DouYinCacheConfig, DouYinHttp {
    private Map<String, DouYinOauthAccessToken> accessTokenMap = new ConcurrentHashMap<>();
    private DouYinClientConfigStorage storage = null;

    public DouYinOauthServiceImpl(DouYinClientConfigStorage storage) {
        this.storage = storage;
    }

    @Override
    public DouYinOauthAccessToken getOauthAccessToken(String code) throws DouYinException {
        if (this.storage == null) {
            return null;
        }
        String data = "client_key=%s&client_secret=%s&code=%s&grant_type=authorization_code";
        data = String.format(data, this.storage.getClientKey(), this.storage.getClientSecret(), code);
        DouYinOauthAccessToken token = this.post(DouYinApiPath.DouYin.OAUTH_ACCESS_TOKEN, data, DouYinOauthAccessToken.class);
        this.setOauthAccessToken(token);
        return token;
    }

    @Override
    public DouYinOauthAccessToken getOauthAccessToken(String openId, boolean forceRefresh) throws DouYinException {
        DouYinOauthAccessToken token = this.accessTokenMap.get(this.getCacheOauthKey(this.storage.getClientKey(), openId));
        if (token != null
            && (forceRefresh || StringUtils.isBlank(token.getAccessToken()) || token.accessTokenExpired())) {
            this.refreshAccessToken(token.getRefreshToken());
        }
        return token;
    }

    @Override
    public void setOauthAccessToken(DouYinOauthAccessToken token) {
        if (token != null) {
            token.setExpiresTime(token.getExpiresIn());
            token.setRefreshExpiresTime(token.getRefreshExpiresIn());
            this.accessTokenMap.put(this.getCacheOauthKey(this.storage.getClientKey(), token.getOpenId()), token);
        }
    }

    @Override
    public DouYinOauthUserInfo getOauthUserInfo(String openId, String accessToken) throws DouYinException {
        String query = String.format("open_id=%s&access_token=%s", openId, accessToken);
        return this.get(DouYinApiPath.DouYin.OAUTH_USER_INFO, query, DouYinOauthUserInfo.class);
    }

    @Override
    public DouYinOauthAccessToken refreshAccessToken(String refreshToken) throws DouYinException {
        String data = String.format("client_key=%s&refresh_token=%s&grant_type=refresh_token", this.storage.getClientKey(), refreshToken);
        DouYinOauthAccessToken token = this.post(DouYinApiPath.DouYin.OAUTH_REFRESH_TOKEN, data, DouYinOauthAccessToken.class);
        this.setOauthAccessToken(token);
        return token;
    }

    @Override
    public void renewRefreshToken(String openId, String refreshToken) throws DouYinException {
        String data = "client_key=%s&refresh_token=%s";
        data = String.format(data, this.storage.getClientKey(), refreshToken);
        DouYinRenewRefreshToken renewRefreshToken = this.post(DouYinApiPath.DouYin.OAUTH_RENEW_REFRESH_TOKEN, data, DouYinRenewRefreshToken.class);
        DouYinOauthAccessToken accessToken = this.getOauthAccessToken(openId, false);
        accessToken.setRefreshToken(renewRefreshToken.getRefreshToken());
        accessToken.setRefreshExpiresIn(renewRefreshToken.getExpiresIn());
        accessToken.setRefreshExpiresTime(renewRefreshToken.getExpiresIn());
    }
}
