package com.nixgap.douyin.open.bean.oauth;

import com.google.gson.annotations.SerializedName;
import com.nixgap.douyin.open.bean.DouYinError;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DouYinOauthAccessToken extends DouYinError {
    @SerializedName("open_id")
    private String openId;
    @SerializedName("scope")
    private String scope;
    @SerializedName("access_token")
    private String accessToken;
    @SerializedName("expires_in")
    private long expiresIn;
    @SerializedName("refresh_token")
    private String refreshToken;
    @SerializedName("refresh_expires_in")
    private long refreshExpiresIn;
    private long expiresTime;
    private long refreshExpiresTime;

    public void setExpiresTime(long expiresIn) {
        this.expiresTime = Calendar.getInstance().getTimeInMillis() + (this.expiresIn - 200) * 1000;
    }

    public void setRefreshExpiresIn(long refreshExpiresIn) {
        this.refreshExpiresTime = Calendar.getInstance().getTimeInMillis() + (this.refreshExpiresIn - 200) * 1000;
    }

    public boolean accessTokenExpired() {
        return Calendar.getInstance().getTimeInMillis() > this.expiresTime;
    }

    public boolean refreshTokenExpired() {
        return Calendar.getInstance().getTimeInMillis() > this.refreshExpiresTime;
    }
}
