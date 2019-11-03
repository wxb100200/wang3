package com.base.wang.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.base.wang.mapper.SysTokenMapper;
import com.base.wang.model.SysToken;
import com.base.wang.model.SysUser;
import com.base.wang.service.SysTokenService;
import com.base.wang.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class SysTokenServiceImpl  extends BaseServiceImpl<SysToken> implements SysTokenService {
    /**
     * token过期秒数
     */
    @Value("${token.expire.seconds}")
    private Integer expireSeconds;
    @Autowired
    private SysTokenMapper sysTokenMapper;


    @Override
    public SysToken findValidToken(String id) {
        return sysTokenMapper.findValidToken(id);
    }

    @Override
    public String saveToken(SysUser loginUser) {
        String token=UUID.randomUUID().toString();//令牌
        long loginTime=System.currentTimeMillis();//登录时间
        long expireTime=loginTime+expireSeconds*1000;//到期时间

        SysToken sysToken=new SysToken();
        sysToken.setId(token);
        sysToken.setExpireTime(new Date(expireTime));
        sysToken.setCreateTime(new Date());
        sysToken.setValue(JSONObject.toJSONString(loginUser));
        sysTokenMapper.insert(sysToken);
        return token;
    }

    /**
     * 删除令牌信息
     * @param token
     */
    @Override
    public void deleteToken(String token) {
        sysTokenMapper.deleteToken(token);
    }

    /**
     * 延长有效时间
     */
    @Override
    public SysToken extendExpireTime(String token) {
        SysToken sysToken=sysTokenMapper.findByToken(token);
        if(sysToken==null)return null;
        long expireTime=System.currentTimeMillis()+expireSeconds*1000;//到期时间
        sysToken.setExpireTime(new Date(expireTime));
        sysToken.setChangeTime(new Date());
        sysTokenMapper.updateByPrimaryKey(sysToken);
        return sysToken;
    }
}
