package com.base.wang.service;

import com.base.wang.model.SysUserRole;
import com.base.wang.service.base.BaseService;

import java.util.List;

public interface SysUserRoleService extends BaseService<SysUserRole> {

    List<SysUserRole> listByUserId(Integer userId);
}
