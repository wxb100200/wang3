package com.base.wang.service.impl;

import com.base.wang.mapper.SysUserMapper;
import com.base.wang.model.SysUser;
import com.base.wang.service.SysUserService;
import com.base.wang.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl  extends BaseServiceImpl<SysUser> implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    /**
     * 根据用户名查找用户
     */
    @Override
    public SysUser selectByName(String username) {
        return sysUserMapper.findByName(username);
    }
}
