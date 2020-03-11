package com.hai.practice.jwt.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hai.practice.jwt.system.entity.SysPermission;
import com.hai.practice.jwt.system.entity.SysRole;
import com.hai.practice.jwt.system.entity.SysUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysUserMapper extends BaseMapper<SysUser> {

    List<SysRole> listRole(Long userId);

    @Select("select p.* from sys_user u JOIN sys_user_role ur USING(user_id) JOIN sys_role r USING(role_id) JOIN sys_role_permission rp USING(role_id) JOIN sys_permission p USING(permission_id) where u.user_id = #{userId}")
    List<SysPermission> listPermission(Long userId);
}
