package com.hai.practice.jwt.system.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hai.practice.jwt.Result;
import com.hai.practice.jwt.system.entity.SysUser;
import com.hai.practice.jwt.system.mapper.SysUserMapper;
import com.hai.practice.jwt.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Slf4j
@RequestMapping("oauth/api")
public class LoginController {

    @Autowired
    private SysUserMapper sysUserMapper;

    @RequestMapping("login")
    public Object login(String userName, String password){
        log.info("---------------login,userName={},password={}", userName, password);
        QueryWrapper<SysUser> query = new QueryWrapper<SysUser>().eq("user_name", userName);
        SysUser sysUser = sysUserMapper.selectOne(query);
        if (sysUser == null) {
           return Result.error("账号不存在");
        }
        if (!Objects.equals(sysUser.getPassword(), password)) {
            return Result.error("密码不正确");
        }
        Map<String,Object> map = new HashMap<>();
        map.put("token", JwtUtil.sign(sysUser.getUserName(), sysUser.getUserId()));
        return map;
    }


}
