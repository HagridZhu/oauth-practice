package com.hai.practice.jwt.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class TestController {

    private Random random = new Random();

    @RequestMapping("test")
    public Object test(String aaa){
        if (aaa == null) {
//            throw new RuntimeException("token is error1");
        }
        return random.nextInt(100);
    }

    @RequiresRoles("r1")
    @RequestMapping("r1")
    public Object r1(){
        return random.nextInt(100);
    }

    @RequiresRoles("admin")
    @RequestMapping("admin")
    public Object admin(){
        return random.nextInt(100);
    }

    @RequestMapping("vip")
    @RequiresPermissions("vip")
    public Object vip(){
        return random.nextInt(100);
    }

    @RequestMapping("user/get")
    @RequiresPermissions("user:get")
    public Object userGet(){
        return random.nextInt(100);
    }

    @RequestMapping("anon/test")
    public Object anonTest(){
        return random.nextInt(100);
    }


}
