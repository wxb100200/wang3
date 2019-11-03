package com.base.wang.mapper;

import com.base.wang.model.SysToken;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface SysTokenMapper extends Mapper<SysToken> {

    @Select("select * from sys_token where id=#{token}")
    SysToken findByToken(String token);

    @Select("SELECT * from sys_token WHERE id=#{token} and expire_time>NOW()")
    SysToken findValidToken(String token);

    @Delete("delete from sys_token where id=#{token}")
    void deleteToken(String token);
}