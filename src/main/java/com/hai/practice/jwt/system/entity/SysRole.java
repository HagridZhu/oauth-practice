package com.hai.practice.jwt.system.entity;

import lombok.Data;

import java.util.Date;

@Data
public class SysRole {
    private Long roleId;
    private String roleName;
    private Date createDate;
}
