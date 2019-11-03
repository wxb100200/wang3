package com.base.wang.service;

import com.base.wang.model.SysToken;
import com.base.wang.model.SysUser;
import com.base.wang.service.base.BaseService;

public interface SysTokenService  extends BaseService<SysToken> {

    SysToken findValidToken(String id);
    //保存令牌
    String saveToken(SysUser loginUser);
    //删除令牌
    void deleteToken(String token);
    //延长有效时间
    SysToken extendExpireTime(String token);
}
