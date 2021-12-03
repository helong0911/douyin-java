package com.nixgap.douyin.open.bean.poi;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DouYinPoiSearchResultItem {
    @SerializedName("poi_id")
    private String poiId;
    @SerializedName("poi_name")
    private String poiName;
    @SerializedName("address")
    private String address;
    @SerializedName("location")
    private String location;
    @SerializedName("country_code")
    private String countryCode;
    @SerializedName("country")
    private String country;
    @SerializedName("province")
    private String province;
    @SerializedName("city")
    private String city;
    @SerializedName("district")
    private String district;
    @SerializedName("city_code")
    private String cityCode;
}
