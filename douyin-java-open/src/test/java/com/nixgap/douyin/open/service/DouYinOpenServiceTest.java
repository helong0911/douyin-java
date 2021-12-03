package com.nixgap.douyin.open.service;

import com.nixgap.douyin.open.exception.DouYinException;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class DouYinOpenServiceTest {

    public void getClientAccessTokenTest() throws DouYinException {
        String token = ServUtils.getDouYinOpenService().getClientAccessToken(false);
        Assert.assertNotNull(token);
    }

    public void getAccessTokenTest() {
        String token = ServUtils.getDouYinOpenService().getClientConfigStorage().getAccessToken();
        Assert.assertNotNull(token);
    }
}
