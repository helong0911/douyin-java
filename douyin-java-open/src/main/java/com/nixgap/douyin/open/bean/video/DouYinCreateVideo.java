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
public class DouYinCreateVideo {
    @SerializedName("video_id")
    private String videoId;
    @SerializedName("text")
    private String text;
    @SerializedName("poi_id")
    private String poiId;
    @SerializedName("poi_name")
    private String poiName;
    @SerializedName("micro_app_id")
    private String microAppId;
    @SerializedName("micro_app_title")
    private String microAppTitle;
    @SerializedName("micro_app_url")
    private String microAppUrl;
    @SerializedName("article_id")
    private String articleId;
    @SerializedName("article_title")
    private String articleTitle;
    @SerializedName("timeliness_label")
    private Integer timelinessLabel;
    @SerializedName("timeliness_keyword")
    private String timelinessKeyword;
    @SerializedName("game_id")
    private String gameId;
    @SerializedName("game_content")
    private String gameContent;
    @SerializedName("cover_tsp")
    private Double coverTsp;
    @SerializedName("at_users")
    private List<String> atUsers;
    @SerializedName("custom_cover_image_url")
    private String customCoverImageUrl;
}
