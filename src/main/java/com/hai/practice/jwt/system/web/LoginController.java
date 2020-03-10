package com.hai.practice.jwt.system.web;

import com.hai.practice.jwt.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Slf4j
public class LoginController {

    @RequestMapping("login")
    public Object login(String userName, String passWord){
        log.info("---------------login,userName={},passWord={}", userName, passWord);
        Map<String, Object> map = new HashMap<>();
        // TODO 连数据库
        if (Objects.equals("admin", userName) && Objects.equals("admin123", passWord)) {
            map.put("msg", "登陆成功");
            map.put("token", JwtUtil.sign(userName, 1));
            return map;
        }

        map.put("msg", "用户或密码错误");
        return map;
    }


}
