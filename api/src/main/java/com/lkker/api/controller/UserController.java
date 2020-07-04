package com.lkker.api.controller;

import com.lkker.api.model.entity.UserInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liliang
 * @Date 2020/7/4 16:14
 * @Description
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/userinfo")
    public UserInfo getUserInfo(){
        UserInfo userInfo = new UserInfo("LX1001","liliang","15810072844");

        return  userInfo;
    }
}
