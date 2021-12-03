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
public class DouYinUploadResultImage {
    @SerializedName("width")
    private long width;
    @SerializedName("height")
    private long height;
    @SerializedName("image_id")
    private String imageId;
}
