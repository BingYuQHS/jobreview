package com.flamingo.jrmessage.exception;

import com.flamingo.jrmessage.enums.ResultEnum;

/**
 * 邮件发送异常处理
 */
public class EmailException extends RuntimeException {

    private Integer code;

    public EmailException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();

    }

    public EmailException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    /** 获取code. */
    public Integer getCode() {
        return code;
    }
}
