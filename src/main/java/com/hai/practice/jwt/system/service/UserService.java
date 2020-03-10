package com.hai.practice.jwt.system.service;

import java.util.List;

public interface UserService {

    List<String> listRole(String loginName);
    List<String> listStringPermission(String loginName);
}
