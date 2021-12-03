package com.nixgap.douyin.open.service;

import com.nixgap.douyin.open.bean.oauth.DouYinOauthAccessToken;
import com.nixgap.douyin.open.bean.oauth.DouYinOauthUserInfo;
import com.nixgap.douyin.open.exception.DouYinException;

/**
 * 帐号授权相关接口
 *
 * @author Sean
 */
public interface DouYinOauthService {
    /**
     * 抖音帐号授权
     * <br>
     * <a href="https://open.douyin.com/platform/doc/6848834666171009035">https://open.douyin.com/platform/doc/6848834666171009035</a>
     *
     * @param code 授权码
     * @return 授权用户信息
     */
    DouYinOauthAccessToken getOauthAccessToken(String code) throws DouYinException;

    /**
     * 抖音帐号授权
     * <br>
     * <a href="https://open.douyin.com/platform/doc/6848834666171009035">https://open.douyin.com/platform/doc/6848834666171009035</a>
     *
     * @param openId       授权用户唯一标识
     * @param forceRefresh 强制刷新
     * @return 授权用户信息
     */
    DouYinOauthAccessToken getOauthAccessToken(String openId, boolean forceRefresh) throws DouYinException;

    /**
     * 添加用户授权信息
     * <br>
     * <a href="https://open.douyin.com/platform/doc/6848834666171009035">https://open.douyin.com/platform/doc/6848834666171009035</a>
     *
     * @param token 用户授权信息
     */
    void setOauthAccessToken(DouYinOauthAccessToken token);


    /**
     * 获取用户信息
     * <br>
     * <a href="https://open.douyin.com/platform/doc/6848806527751489550">https://open.douyin.com/platform/doc/6848806527751489550</a>
     *
     * @param openId      用户唯一标志
     * @param accessToken
     * @return 授权用户信息
     */
    DouYinOauthUserInfo getOauthUserInfo(String openId, String accessToken) throws DouYinException;

    /**
     * 刷新access_token
     * <br>
     * <a href="https://open.douyin.com/platform/doc/6848806497707722765">https://open.douyin.com/platform/doc/6848806497707722765</a>
     *
     * @param refreshToken 通过access_token获取到的refresh_token参数
     * @return 授权用户信息
     */
    DouYinOauthAccessToken refreshAccessToken(String refreshToken) throws DouYinException;

    /**
     * 刷新refresh_token
     * <br>
     * <a href="https://open.douyin.com/platform/doc/6848806519174154248">https://open.douyin.com/platform/doc/6848806519174154248</a>
     *
     * @param openId       用户唯一标志
     * @param refreshToken 通过access_token获取到的refresh_token参数
     */
    void renewRefreshToken(String openId, String refreshToken) throws DouYinException;
}
