package com.hai.practice.jwt.web;

import com.hai.practice.jwt.util.JwtUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @RequestMapping("/login")
    public String login(String loginName, Integer userId){
        return JwtUtil.sign(loginName, userId);
    }

    @RequestMapping("test")
    public Object test(){
        return "success";
    }

    @RequestMapping("r1")
    public Object r1(){
        return "r1";
    }


}
