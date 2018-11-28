package com.flamingo.jrmessage.enums;

import lombok.Getter;

/**
 * 消息队列枚举
 */
@Getter
public enum MqQueueEnum {

    EMAIL_CODE_QUEUE("email.code.queue","发送邮件验证码队列"),

    MOBILE_CODE_QUEUE("mobile.code.queue","发送短信验证码队列"),

    EMAIL_QUEUE("email.queue","发送邮件队列"),

    MOBILE_QUEUE("mobile.queue","发送短信队列"),
    ;
    private String queueName;

    private String detail;

    MqQueueEnum(String queueName, String detail) {
        this.queueName = queueName;
        this.detail = detail;
    }
}
