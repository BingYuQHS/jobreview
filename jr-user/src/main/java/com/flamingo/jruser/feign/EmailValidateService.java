package com.flamingo.jruser.feign;

import com.flamingo.jruser.model.vo.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 邮箱验证接口
 * 调用jr-message的接口
 */
@FeignClient(name = "jr-message")
public interface EmailValidateService {
    @GetMapping("/email/generalMail")
    ResultVO generalMail(@RequestParam(value = "toUser") String toUser,
                                @RequestParam(value = "subject")String  subject,
                                @RequestParam(value = "content")String content);
}
