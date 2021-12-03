package com.nixgap.douyin.open.service;

import com.nixgap.douyin.open.bean.poi.DouYinPoiSearchResult;
import com.nixgap.douyin.open.exception.DouYinException;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class DouYinPoiServiceTest {

    private DouYinPoiService poiService = null;

    public DouYinPoiServiceTest() {
        poiService = ServUtils.getDouYinOpenService().getDouYinPoiService();
    }

    public void getPoiSearchKeywordTest() throws DouYinException {
        DouYinPoiSearchResult result = poiService.getPoiSearchKeyword("上海", "哥老官", 0, 20);
        Assert.assertNotNull(result);
    }
}
