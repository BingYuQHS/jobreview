package com.flamingo.jrmessage.enums;

import lombok.Getter;

/**
 * 返回前端的消息枚举
 */
@Getter
public enum ResultEnum {
    SEND_EMAIL_FIAL(10001,"发送邮件失败"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
