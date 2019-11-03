package com.base.wang.mapper;

import com.base.wang.model.SysUser;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface SysUserMapper extends Mapper<SysUser> {
    @Select("select * from sys_user where name=#{name}")
    SysUser findByName(String name);
}