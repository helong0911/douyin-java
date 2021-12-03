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
public class DouYinCreateResult extends DouYinError {
    @SerializedName("item_id")
    private String itemId;
}
