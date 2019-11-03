package com.base.wang.mapper;

import com.base.wang.model.BasTest;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface BasTestMapper extends Mapper<BasTest> {

    @Select("select * from bas_test where id=#{id}")
    BasTest findById(Integer id);
    @Select("select * from bas_test ")
    List<BasTest> findAll();
}