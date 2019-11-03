package com.base.wang.mapper;

import com.base.wang.model.SysUserRole;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface SysUserRoleMapper extends Mapper<SysUserRole> {

    @Select("select * from sys_user_role where user_id=#{userId}")
    List<SysUserRole> findByUserId(Integer userId);
}