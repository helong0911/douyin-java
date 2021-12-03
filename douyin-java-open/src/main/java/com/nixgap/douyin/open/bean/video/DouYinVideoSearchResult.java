package com.nixgap.douyin.open.bean.video;

import com.google.gson.annotations.SerializedName;
import com.nixgap.douyin.open.bean.DouYinError;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DouYinVideoSearchResult extends DouYinError {
    @SerializedName("cursor")
    private long cursor;
    @SerializedName("has_more")
    private boolean hasMore;
    @SerializedName("list")
    private List<DouYinVideoSearchResultItem> list;
}
