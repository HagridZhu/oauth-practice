package com.hai.practice.jwt.system.entity;

import lombok.Data;

import java.util.Date;

@Data
public class SysPermission {
    private Long permissionId;
    private String permission;
    private String remark;
    private Date createDate;
}
