package com.flamingo.jrmessage.service;

import javax.mail.MessagingException;

/**
 * 常用的邮件形式接口封装
 */
public interface IMailService {

    /**
     * 发送文本邮件
     * @param to
     * @param subject
     * @param content
     */
    void sendSimpleMail(String to, String subject, String content) throws MessagingException;
    void sendSimpleMail(String to, String subject,String content, String... cc) throws MessagingException;

    /**
     * 发送HTML邮件
     * @param to
     * @param subject
     * @param content
     * @throws MessagingException
     */
    void sendHtmlMail(String to, String subject, String content) throws MessagingException;
    void sendHtmlMail(String to, String subject, String content, String... cc) throws MessagingException;

    /**
     * 发送带附件的邮件
     * @param to
     * @param subject
     * @param content
     * @param filePath
     * @throws MessagingException
     */
    void sendAttachmentMail(String to, String subject, String content, String filePath) throws MessagingException;
    void sendAttachmentMail(String to, String subject, String content, String filePath, String... cc) throws MessagingException;

    /**
     * 发送正文中有静态资源的邮件
     * @param to
     * @param subject
     * @param content
     * @param rscPath
     * @param rscId
     * @throws MessagingException
     */
    void sendResourceMail(String to, String subject, String content, String rscPath, String rscId) throws MessagingException;
    void sendResourceMail(String to, String subject, String content, String rscPath, String rscId, String... cc) throws MessagingException;

    /**
     * 添加内容主题限制
     * @param toUser
     * @param subject
     * @param content
     * @return
     */
    boolean sendGeneralEmail(String toUser, String subject, String content);

}
