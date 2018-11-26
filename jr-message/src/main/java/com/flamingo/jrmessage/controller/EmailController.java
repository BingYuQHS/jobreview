package com.flamingo.jrmessage.controller;

import com.flamingo.jrmessage.model.ResultVO;
import com.flamingo.jrmessage.service.IMailService;
import com.flamingo.jrmessage.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;

@RestController
@RequestMapping("/email")
@Slf4j
public class EmailController {
    @Autowired
    private IMailService mailService;

    //注入模板引擎
    @Resource
    private TemplateEngine templateEngine;

    @GetMapping("/simpleMail")
    public ResultVO simpleMail(){
        try {
            mailService.sendSimpleMail("1756217895@qq.com","标题：测试标题","这是一封普通的SpringBoot测试邮件");
        }catch (Exception e){
            log.error("【发送普通邮件】 邮件发送失败");
            return R.error(10000,"邮件发送失败");
            // throw new EmailException(ResultEnum.SEND_EMAIL_FIAL);
        }
        return R.ok();
    }

    @RequestMapping("/htmlEmail")
    public ResultVO htmlEmail(){
        try {
            mailService.sendHtmlMail("1756217895@qq.com","IJPay让支付触手可及","<body style=\"text-align: center;margin-left: auto;margin-right: auto;\">\n"
                    + "	<div id=\"welcome\" style=\"text-align: center;position: absolute;\" >\n"
                    +"		<h3>欢迎使用IJPay -By Javen</h3>\n"
                    +"		<span>https://github.com/Javen205/IJPay</span>"
                    + "		<div\n"
                    + "			style=\"text-align: center; padding: 10px\"><a style=\"text-decoration: none;\" href=\"https://github.com/Javen205/IJPay\" target=\"_bank\" ><strong>IJPay 让支付触手可及,欢迎Start支持项目发展:)</strong></a></div>\n"
                    + "		<div\n" + "			style=\"text-align: center; padding: 4px\">如果对你有帮助,请任意打赏</div>\n"
                    + "		<img width=\"180px\" height=\"180px\"\n"
                    + "			src=\"https://javen205.gitbooks.io/ijpay/content/assets/wxpay.png\">\n"
                    + "	</div>\n" + "</body>");
        }catch (Exception e){
            log.error("【发送html邮件】 邮件发送失败");
            return R.error(10000,"邮件发送失败");
            // throw new EmailException(ResultEnum.SEND_EMAIL_FIAL);
        }
        return R.ok();
    }

    @RequestMapping("/attachmentMail")
    public ResultVO attachmentsMail(){
        try {
            String filePath = "D:\\picture\\common_stu\\image\\qqpic4.jpg";
            mailService.sendAttachmentMail("1756217895@qq.com", "这是一封带附件的邮件", "邮件中有附件，请注意查收！", filePath);
        }catch (Exception e){
            log.error("【发送带附件邮件】 邮件发送失败");
            return R.error(10000,"邮件发送失败");
            // throw new EmailException(ResultEnum.SEND_EMAIL_FIAL);
        }
        return R.ok();
    }

    @RequestMapping("/resourceMail")
    public ResultVO resourceMail(){
        try {
            String rscId = "qqpic4";
            String content = "<html><body>这是有图片的邮件<br/><img src=\'cid:" + rscId + "\' ></body></html>";
            String imgPath = "D:/picture/common_stu/image/qqpic4.jpg";
            mailService.sendResourceMail("1756217895@qq.com", "这邮件中含有图片", content, imgPath, rscId);

        }catch (Exception e){
            log.error("【发送正文中有静态资源的邮件】 邮件发送失败");
            return R.error(10000,"邮件发送失败");
            // throw new EmailException(ResultEnum.SEND_EMAIL_FIAL);
        }
        return R.ok();
    }

    /**
     * 发送模板邮件 thymeleaf模板
     * @return
     */
    @RequestMapping("/templateMail")
    public ResultVO templateMail(){
        try {
            Context context = new Context();
            context.setVariable("project", "IJPay");
            context.setVariable("author", "Javen");
            context.setVariable("url", "https://github.com/Javen205/IJPay");
            String emailContent = templateEngine.process("emailTemp", context);

            mailService.sendHtmlMail("1756217895@qq.com", "这是模板邮件", emailContent);
        }catch (Exception ex){
            log.error("【发送模板邮件】 邮件发送失败");
            return R.error(10002,"模板邮件发送失败");
            // throw new EmailException(ResultEnum.SEND_EMAIL_FIAL);
        }
        return R.ok();
    }

}
