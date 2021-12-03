package com.nixgap.douyin.open.bean.video;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DouYinVideoSearchResultItem {
    @SerializedName("item_id")
    private String itemId;
    @SerializedName("sec_item_id")
    private String secItemId;
    @SerializedName("title")
    private String title;
    @SerializedName("cover")
    private String cover;
    @SerializedName("share_url")
    private String shareUrl;
    @SerializedName("open_id")
    private String openId;
    @SerializedName("nickname")
    private String nickname;
    @SerializedName("avatar")
    private String avatar;
    @SerializedName("is_top")
    private String isTop;
    @SerializedName("is_reviewed")
    private String isReviewed;
    @SerializedName("create_time")
    private String createTime;
}
