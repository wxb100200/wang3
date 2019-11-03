package com.base.wang.service.impl;

import com.base.wang.mapper.SysRoleMapper;
import com.base.wang.model.SysRole;
import com.base.wang.model.SysUser;
import com.base.wang.service.SysRoleService;
import com.base.wang.service.SysUserService;
import com.base.wang.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole> implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Override
    public SysRole findById(Integer id) {
        return sysRoleMapper.selectByPrimaryKey(id);
    }
}
