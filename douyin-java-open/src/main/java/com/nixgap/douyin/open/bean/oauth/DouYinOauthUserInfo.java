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
public class DouYinOauthUserInfo extends DouYinError {
    @SerializedName("union_id")
    private String unionId;
    @SerializedName("open_id")
    private String openId;
    @SerializedName("nickname")
    private String nickName;
    @SerializedName("avatar")
    private String avatar;
    @SerializedName("gender")
    private String gender;
    @SerializedName("country")
    private String country;
    @SerializedName("province")
    private String province;
    @SerializedName("city")
    private String city;
}
