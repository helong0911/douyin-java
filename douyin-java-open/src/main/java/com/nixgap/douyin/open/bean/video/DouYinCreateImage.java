package com.nixgap.douyin.open.bean.video;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DouYinCreateImage {
    @SerializedName("micro_app_id")
    private String microAppId;
    @SerializedName("micro_app_title")
    private String microAppTitle;
    @SerializedName("micro_app_url")
    private String microAppUrl;
    @SerializedName("poi_id")
    private String poiId;
    @SerializedName("poi_name")
    private String poiName;
    @SerializedName("text")
    private String text;
    @SerializedName("at_users")
    private List<String> atUsers;
    @SerializedName("image_id")
    private String imageId;
}
