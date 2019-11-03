package com.base.wang.service;

import com.base.wang.model.SysRole;
import com.base.wang.service.base.BaseService;

public interface SysRoleService extends BaseService<SysRole> {
    //查找系统角色
    SysRole findById(Integer id);
}
