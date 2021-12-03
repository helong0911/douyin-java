package com.nixgap.douyin.open.bean.video;

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
public class DouYinUploadResult extends DouYinError {
    /**
     * 上传视频时，该对象有值
     */
    @SerializedName("video")
    private DouYinUploadResultVideo video;
    /**
     * 上传图片时，该对象有值
     */
    @SerializedName("image")
    private DouYinUploadResultImage image;
}
