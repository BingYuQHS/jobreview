package com.flamingo.jruser.enums;

import lombok.Getter;

/**
 * 返回前端的消息枚举
 */
@Getter
public enum ResultEnum {
    SAVE_USER_FAILD(20001,"存入用户失败"),

    SAVE_COMPANY_FAILD(20002,"存入企业失败"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
