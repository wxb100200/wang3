package com.base.wang.service.impl;

import com.base.wang.mapper.SysUserRoleMapper;
import com.base.wang.model.SysUserRole;
import com.base.wang.service.SysUserRoleService;
import com.base.wang.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRole> implements SysUserRoleService {
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Override
    public List<SysUserRole> listByUserId(Integer userId) {
        return sysUserRoleMapper.findByUserId(userId);
    }
}
