package com.hai.practice.jwt.system.entity;

import lombok.Data;

import java.util.Date;

@Data
public class SysUser {
    private Long userId;
    private String userName;
    private String passWord;
    private Date createDate;

}
