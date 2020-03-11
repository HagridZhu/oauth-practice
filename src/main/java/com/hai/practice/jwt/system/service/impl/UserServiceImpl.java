package com.hai.practice.jwt.system.service.impl;

import com.hai.practice.jwt.system.entity.SysPermission;
import com.hai.practice.jwt.system.entity.SysRole;
import com.hai.practice.jwt.system.mapper.SysUserMapper;
import com.hai.practice.jwt.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<String> listRole(Long userId) {
        log.info("--------------------- listRole ---------------------");
        return sysUserMapper.listRole(userId).stream().map(SysRole::getRoleName).collect(toList());
    }

    @Override
    public List<String> listStringPermission(Long userId) {
        log.info("--------------------- listStringPermission ---------------------");
        return sysUserMapper.listPermission(userId).stream().map(SysPermission::getPermission).collect(toList());
    }
}
