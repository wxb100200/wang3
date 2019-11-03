package com.base.wang.service;

import com.base.wang.model.SysUser;
import com.base.wang.service.base.BaseService;

public interface SysUserService extends BaseService<SysUser> {
    //根据用户名查找用户
    SysUser selectByName(String username);
}
