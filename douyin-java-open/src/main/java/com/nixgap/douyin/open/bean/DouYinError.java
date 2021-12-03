package com.nixgap.douyin.open.bean;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class DouYinError {
    @SerializedName("error_code")
    private String errorCode;
    @SerializedName("description")
    private String description;
}
