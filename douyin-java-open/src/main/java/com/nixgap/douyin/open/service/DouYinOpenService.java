package com.nixgap.douyin.open.service;


import com.nixgap.douyin.open.config.DouYinClientConfigStorage;
import com.nixgap.douyin.open.exception.DouYinException;

/**
 * 服务访问入口
 *
 * @author Sean
 */
public interface DouYinOpenService {
    /**
     * 添加应用配置，可支持多个，以 client_key 标识
     *
     * @param config 应用配置项
     */
    void setClientConfigStorage(DouYinClientConfigStorage config);

    /**
     * 获取应用配置
     */
    DouYinClientConfigStorage getClientConfigStorage();

    /**
     * 获取应用 Access Token
     * <br>
     * 需要通过 setClientConfig 进行添加
     *
     * @return
     */
    String getClientAccessToken(boolean forceRefresh) throws DouYinException;

    /**
     * 获取授权码(code)
     * <br>
     * <a href="https://open.douyin.com/platform/doc/6848834666171009035">https://open.douyin.com/platform/doc/6848834666171009035</a>
     *
     * @param responseType  写死为'code'即可
     * @param scope         应用授权作用域,多个授权作用域以英文逗号（,）分隔
     * @param optionalScope 应用授权可选作用域,
     * @param redirectUri   授权成功后的回调地址
     * @param state         用于保持请求和回调的状态
     * @return 用户授权连接
     */
    String getPlatformOauthConnect(String responseType, String scope, String optionalScope, String redirectUri, String state);

    /**
     * 获取授权码(code)
     * <br>
     * <a href="https://open.douyin.com/platform/doc/6848834666170959883">https://open.douyin.com/platform/doc/6848834666170959883</a>
     *
     * @param responseType 写死为'code'即可
     * @param scope        填login_id
     * @param redirectUri  授权成功后的回调地址
     * @param state        用于保持请求和回调的状态
     * @return 静默授权连接
     */
    String getOauthAuthorizeV2(String responseType, String scope, String redirectUri, String state);

    /**
     * 帐号授权相关接口
     * <br>
     * <a href="https://open.douyin.com/platform/doc/6848834666171009035">https://open.douyin.com/platform/doc/6848834666171009035</a>
     *
     * @return 帐号授权相关接口
     */
    DouYinOauthService getOpenOauthService();

    /**
     * POI相关接口
     * <br>
     * <a href="https://open.douyin.com/platform/doc/6848806527751555086">https://open.douyin.com/platform/doc/6848806527751555086</a>
     *
     * @return POI操作对象
     */
    DouYinPoiService getDouYinPoiService();

    /**
     * 关键词搜索相关接口
     * <br>
     * <a href="https://open.douyin.com/platform/doc/6848806544931358733">https://open.douyin.com/platform/doc/6848806544931358733</a>
     *
     * @return 搜索操作对象
     */
    DouYinVideoService getDouYinVideoService(String openId);
}
