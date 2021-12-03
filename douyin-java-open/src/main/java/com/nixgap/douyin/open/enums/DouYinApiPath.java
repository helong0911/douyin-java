package com.nixgap.douyin.open.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

public interface DouYinApiPath {
    /**
     * 获取API完整地址
     *
     * @return API完整地址
     */
    default String getUrl() {
        return this.getHost().buildUrl(this.getPath());
    }

    DouYinApiHost getHost();

    String getPath();

    @AllArgsConstructor
    @Getter
    enum DouYin implements DouYinApiPath {
        /**
         * 发布图片
         * <br>
         * 该接口用于发布图片抖音（支持话题，小程序等功能）；该接口适用于抖音。
         */
        IMAGE_CREATE("/image/create/"),

        /**
         * 上传图片到文件服务器
         * <br>
         * 该接口用于上传图片到文件服务器，得到图片的唯一标志image_id。该接口适用于抖音。
         */
        IMAGE_UPLOAD("/image/upload/"),

        /**
         * 上传视频
         * <br>
         * 该接口用于上传视频文件到文件服务器，获取视频文件video_id。该接口适用于抖音。
         */
        VIDEO_UPLOAD("/video/upload/"),

        /**
         * 创建抖音视频
         * <br>
         * 该接口用于创建抖音视频（支持话题, 小程序等功能）。该接口适用于抖音。
         */
        VIDEO_CREATE("/video/create/"),

        /**
         * 关键词视频搜索
         * <br>
         * 该接口用于通过关键词搜索全站视频,类似抖音端上搜索。使用前请到 管理中心-应用详情-关键词视频管理-关键词管理 创建关键词。
         */
        VIDEO_SEARCH("/video/search/"),

        /**
         * 评论列表
         */
        VIDEO_SEARCH_COMMENT_LIST("/video/search/comment/list/"),

        /**
         * 查询POI信息
         * <br>
         * 该接口用于poi信息的查询，应用场景为在发布内容时查询并携带该poi信息发布至抖音
         */
        POI_SEARCH_KEYWORD("/poi/search/keyword/"),

        /**
         * 生成client_token
         * <br>
         * 该接口用于获取接口调用的凭证client_access_token，主要用于调用不需要用户授权就可以调用的接口；该接口适用于抖音/头条授权。
         */
        OAUTH_CLIENT_TOKEN("/oauth/client_token/"),

        /**
         * 获取授权码(code)
         * <br>
         * 该接口只适用于抖音获取授权临时票据（code）。
         */
        PLATFORM_OAUTH_CONNECT("/platform/oauth/connect/"),

        /**
         * 获取access_token
         * <br>
         * 该接口用于获取用户授权第三方接口调用的凭证access_token；该接口适用于抖音/头条授权。
         */
        OAUTH_ACCESS_TOKEN("/oauth/access_token/"),

        /**
         * 获取用户信息
         * <br>
         * 该接口获取用户的抖音公开信息，包含昵称、头像、性别和地区；适用于抖音。
         */
        OAUTH_USER_INFO("/oauth/userinfo/"),

        /**
         * 刷新access_token
         * <br>
         * 该接口用于刷新access_token的有效期；该接口适用于抖音/头条授权。
         */
        OAUTH_REFRESH_TOKEN("/oauth/refresh_token/"),

        /**
         * 刷新refresh_token
         * <br>
         * 该接口用于刷新refresh_token的有效期；该接口适用于抖音授权。
         */
        OAUTH_RENEW_REFRESH_TOKEN("/oauth/renew_refresh_token/");

        private final DouYinApiHost host = DouYinApiHost.DOUYIN;
        private final String path;

        @Override
        public String toString() {
            return this.getUrl();
        }
    }

    @AllArgsConstructor
    @Getter
    enum DouYinSNS implements DouYinApiPath {
        /**
         * 获取授权码(code)
         * <br>
         * 该接口适用于抖音获取静默授权临时票据（code）。
         */
        OAUTH_AUTHORIZE_V2("/oauth/authorize/v2/");

        private final DouYinApiHost host = DouYinApiHost.DOUYINSNS;
        private final String path;

        @Override
        public String toString() {
            return this.getUrl();
        }
    }
}
