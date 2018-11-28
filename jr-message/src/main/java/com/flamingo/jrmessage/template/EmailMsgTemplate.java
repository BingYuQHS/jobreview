package com.flamingo.jrmessage.template;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 封装邮件Template
 */
@Data
public class EmailMsgTemplate implements Serializable {

    /** 邮件接收方. */
    private String to;

    /** 邮件主题信息. */
    private String subject;

    /** 邮件主体内容. */
    private String content;

    /** 邮件通道. */
    private String channel;//通道，MQ与外部打交道都是通过Channel来的，发布消息、订阅队列还是接收消息，这些动作都是通过Channel完成；简单来说就是消息通过Channel塞进队列或者流出队列

    public EmailMsgTemplate(String to, String subject, String content, String channel) {
        this.to = to;
        this.subject = subject;
        this.content = content;
        this.channel = channel;
    }

    public EmailMsgTemplate(){

    }

}
