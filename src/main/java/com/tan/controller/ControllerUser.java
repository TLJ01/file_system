package com.tan.controller;

import com.tan.dto.LoginDTO;
import com.tan.dto.RegisterDTO;
import com.tan.dto.SaveUserDTO;
import com.tan.dto.UpdateUserDTO;
import com.tan.entity.EntityUser;
import com.tan.service.ServiceUser;
import com.tan.entity.EntityResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class ControllerUser {

    @Autowired
    private ServiceUser serviceUser;

    /**
     * 注册
     * @param registerDTO
     * @return
     */
    @PostMapping("/register")
    public EntityResult register(@RequestBody RegisterDTO registerDTO) {
        log.info("registerDTO:{}", registerDTO);
        return serviceUser.register(registerDTO);
    }


    /**
     * 登录
     * @param loginDTO
     * @return
     */
    @PostMapping("/login")
    public EntityResult login(@RequestBody LoginDTO loginDTO){
        log.info("loginDTO:{}", loginDTO);
        return serviceUser.login(loginDTO);
    }

    /**
     * 获取当前用户信息
     * @return
     */
    @GetMapping("/info")
    public EntityResult getUserInfo(){
        return serviceUser.getUserInfo();
    }

    /**
     * 获取用户列表
     * @return
     */
    @GetMapping("/list")
    public EntityResult list(){
        return serviceUser.list();
    }

    /**
     * 添加用户-->大部分默认
     * @param saveUserDTO
     * @return
     */
    @PostMapping
    public EntityResult save(@RequestBody SaveUserDTO saveUserDTO){
        return serviceUser.save(saveUserDTO);
    }

    /**
     * 更新用户信息
     * @param updateUserDTO
     * @return
     */
    @PutMapping
    public EntityResult update(@RequestBody UpdateUserDTO updateUserDTO){
        return serviceUser.update(updateUserDTO);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping
    public EntityResult delete(Integer id){
        return serviceUser.deleteById(id);
    }


    /**
     * 退出登录
     * @return
     */
    @PostMapping("/logout")
    public EntityResult logout(){
        return serviceUser.logout();
    }

}