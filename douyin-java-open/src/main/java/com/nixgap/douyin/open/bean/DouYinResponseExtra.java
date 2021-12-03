package com.nixgap.douyin.open.bean;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class DouYinResponseExtra extends DouYinError {
    @SerializedName("logid")
    private String logId;
    @SerializedName("now")
    private long now;
    @SerializedName("sub_error_code")
    private String subErrorCode;
    @SerializedName("sub_description")
    private String subDescription;
}
