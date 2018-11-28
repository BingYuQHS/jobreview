package com.flamingo.jrmessage.enums;

import lombok.Getter;

/**
 * 返回前端的消息枚举
 */
@Getter
public enum ResultEnum {
    SEND_EMAIL_FIAL(10001,"发送邮件失败"),

    EMAIL_CONTENT_ERROR(10002,"邮件内容超出限制"),

    EMAIL_SUBJECT_ERROR(10003,"邮件主题超出限制"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
