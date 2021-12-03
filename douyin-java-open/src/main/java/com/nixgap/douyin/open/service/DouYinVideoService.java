package com.nixgap.douyin.open.service;

import com.nixgap.douyin.open.bean.video.*;
import com.nixgap.douyin.open.exception.DouYinException;

import java.io.File;

/**
 * 视频相关接口
 *
 * @author Sean
 */
public interface DouYinVideoService {
    /**
     * 上传图片文件
     * <br>
     * <a href="https://open.douyin.com/platform/doc/6848798493293807628">https://open.douyin.com/platform/doc/6848798493293807628</a>
     *
     * @param image 图片文件
     * @return 返回上传结果
     */
    DouYinUploadResult imageUpload(File image) throws DouYinException;

    /**
     * 发布图片
     * <br>
     * <a href="https://open.douyin.com/platform/doc/6848798087398328323">https://open.douyin.com/platform/doc/6848798087398328323</a>
     *
     * @param image 图片对象
     * @return 返回发布结果
     */
    DouYinCreateResult imageCreate(DouYinCreateImage image) throws DouYinException;

    /**
     * 上传视频文件
     * <br>
     * <a href="https://open.douyin.com/platform/doc/6848798087398295555">https://open.douyin.com/platform/doc/6848798087398295555</a>
     *
     * @param video 视频文件
     * @return 返回上传结果
     */
    DouYinUploadResult videoUpload(File video) throws DouYinException;

    /**
     * 创建抖音视频
     * <br>
     * <a href="https://open.douyin.com/platform/doc/6848798087398328323">https://open.douyin.com/platform/doc/6848798087398328323</a>
     *
     * @param video 视频对象
     * @return 返回创建结果
     */
    DouYinCreateResult videoCreate(DouYinCreateVideo video) throws DouYinException;

    /**
     * 关键词视频搜索
     * <br>
     * <a href="https://open.douyin.com/platform/doc/6848806544931358733">https://open.douyin.com/platform/doc/6848806544931358733</a>
     *
     * @param keyword 查询关键字
     * @param cursor  分页游标, 第一页请求cursor是0, response中会返回下一页请求用到的cursor, 同时response还会返回has_more来表明是否有更多的数据
     * @param count   每页数量
     * @return 返回查询结果
     */
    DouYinVideoSearchResult getVideoSearch(String keyword, long cursor, long count) throws DouYinException;
}
