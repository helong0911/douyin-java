package com.nixgap.douyin.open.bean.oauth;

import com.google.gson.annotations.SerializedName;
import com.nixgap.douyin.open.bean.DouYinError;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DouYinRenewRefreshToken extends DouYinError {
    @SerializedName("expires_in")
    private long expiresIn;
    @SerializedName("refresh_token")
    private String refreshToken;
}
