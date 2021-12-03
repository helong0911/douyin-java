package com.nixgap.douyin.open.service;

import com.nixgap.douyin.open.bean.poi.DouYinPoiSearchResult;
import com.nixgap.douyin.open.exception.DouYinException;

/**
 * POI相关接口
 *
 * @author Sean
 */
public interface DouYinPoiService {
    /**
     * 查询POI信息
     * <br>
     * <a href="https://open.douyin.com/platform/doc/6848806527751555086">https://open.douyin.com/platform/doc/6848806527751555086</a>
     *
     * @param city    查询城市，例如上海、北京
     * @param keyword 查询关键字，例如美食
     * @param cursor  分页游标, 第一页请求cursor是0, response中会返回下一页请求用到的cursor, 同时response还会返回has_more来表明是否有更多的数据
     * @param count   每页数量
     * @return 返回查询结果
     */
    DouYinPoiSearchResult getPoiSearchKeyword(String city, String keyword, long cursor, long count) throws DouYinException;
}
