package com.nixgap.douyin.open.exception;

import lombok.Data;

/**
 * 抖音统一异常输出
 *
 * @author Sean
 */
@Data
public class DouYinException extends Exception {
    /**
     * 状态码
     * <br>
     * 500为系统异常，其它为抖音返回状态码
     * <br>
     * <a href="https://open.douyin.com/platform/doc/6850392252464809992">https://open.douyin.com/platform/doc/6850392252464809992</a>
     */
    private String errorCode;
    /**
     * 错误码描述
     */
    private String description;

    public DouYinException(String errorCode, String description) {
        super(description);
        this.errorCode = errorCode;
        this.description = description;
    }

    public DouYinException(String errorCode, Exception exception) {
        super(exception);
        this.errorCode = errorCode;
        this.description = exception.getMessage();
    }
}
