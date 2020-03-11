package com.hai.practice.jwt.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hai.practice.jwt.system.entity.SysUser;
import com.hai.practice.jwt.system.mapper.SysUserMapper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@RestController
public class TestController {

    private Random random = new Random();
    @Autowired
    private SysUserMapper sysUserMapper;

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

    @RequestMapping("sys/user/add")
    public Object addUser(){
        SysUser sysUser = new SysUser();
        sysUser.setUserName("hai-" + new Random().nextInt(100));
        sysUser.setCreateDate(new Date());
        return sysUserMapper.insert(sysUser);
    }

    @RequestMapping("sys/user/list")
    public Object listUser(){
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.like("user_name", "hai");
        return sysUserMapper.selectPage(new Page<>(1,10,false), wrapper);
    }


}
