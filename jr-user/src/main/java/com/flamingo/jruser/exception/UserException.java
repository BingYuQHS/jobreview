package com.flamingo.jruser.exception;


import com.flamingo.jruser.enums.ResultEnum;

/**
 * 用户异常处理
 */
public class UserException extends RuntimeException{

    private Integer code;

    public UserException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();

    }

    public UserException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    /** 获取code. */
    public Integer getCode() {
        return code;
    }
}
