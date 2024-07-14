package com.tan.controller;

import cn.hutool.core.util.RandomUtil;
import com.tan.service.ServicePublic;
import com.tan.entity.EntityResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 公共Controller
 */
@Slf4j
@RestController
public class ControllerPublic {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ServicePublic servicePublic;

    @GetMapping("/captcha")
    public EntityResult generateCaptcha() {
        // 生成验证码
        String captcha = generateRandomCaptcha();
        log.info("captcha:{}", captcha);
        // 将验证码存入Redis，设置过期时间（例如5分钟）
        //这里存入验证码一样,多人使用的时候可能会出错,到时候随机数字或者用户信息来解决
        redisTemplate.opsForValue().set("captcha", captcha, 2, TimeUnit.MINUTES);
        // 返回生成的验证码给前端，这里可以返回图形验证码的Base64编码字符串或其他形式
        return EntityResult.success(captcha);
    }

    private String generateRandomCaptcha() {
        // 生成随机的验证码逻辑
        return RandomUtil.randomString("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789", 4);
    }

//    private String generateCaptchaImageBase64(String captcha) {
//
//        // 定义图形验证码的长和宽
//        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 90, 4, 100);
//
//        // 生成验证码图片的Base64编码，实际项目中需要使用图形库生成验证码图片，并转换成Base64格式
//
//        return "base64encodedimage"; // 示例：实际需要替换成生成的Base64编码字符串
//    }


    @GetMapping("/code")
    public EntityResult sentEmailCode(String email){
        return servicePublic.sendEmailCode(email);
    }

}