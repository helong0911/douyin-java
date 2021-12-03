package com.nixgap.douyin.open.service;

import com.nixgap.douyin.open.bean.oauth.DouYinOauthAccessToken;
import com.nixgap.douyin.open.bean.video.*;
import com.nixgap.douyin.open.exception.DouYinException;
import com.nixgap.douyin.open.service.impl.DouYinVideoServiceImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.net.URL;

@Test
public class DouYinVideoServiceTest {

    private DouYinVideoService videoService = null;

    public DouYinVideoServiceTest() {
        DouYinOauthAccessToken accessToken = new DouYinOauthAccessToken();
        accessToken.setOpenId(ServUtils.OPEN_ID);
        accessToken.setAccessToken(ServUtils.ACCESS_TOKEN);
        videoService = new DouYinVideoServiceImpl(accessToken);
    }

    public void getVideoSearchTest() throws DouYinException {
//        DouYinVideoSearchResult result = videoService.getVideoSearch("美食", 0, 20);
//        Assert.assertNotNull(result);
    }

    public void imageCreateTest() {
        try {
//            // Upload image
//            URL path = this.getClass().getResource("/image/douyin.jpg");
//            File file = new File(path.getFile());
//            DouYinUploadResult uploadResult = videoService.imageUpload(file);
//            Assert.assertNotNull(uploadResult);
//
//            // Create image
//            DouYinCreateImage image = DouYinCreateImage.builder()
//                .imageId(uploadResult.getImage().getImageId())
//                .text("#抖音")
//                .build();
//            DouYinCreateResult createResult = videoService.imageCreate(image);
//            Assert.assertNotNull(createResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void videoCreateTest() {
        try {
//            // Upload video
//            URL path = this.getClass().getResource("/image/douyin.jpg");
//            File file = new File(path.getFile());
//            DouYinUploadResult uploadResult = videoService.videoUpload(file);
//            Assert.assertNotNull(uploadResult);
//
//            // Create video
//            DouYinCreateVideo video = DouYinCreateVideo.builder()
//                .videoId(uploadResult.getVideo().getVideoId())
//                .text("#抖音")
//                .build();
//            DouYinCreateResult createResult = videoService.videoCreate(video);
//            Assert.assertNotNull(createResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
