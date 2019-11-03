package com.base.wang.service.base;


import com.base.wang.mapper.ConfigParamMapper;
import com.base.wang.model.ConfigParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YScredit on 2018/8/14.
 */
@Service("configParamService")
public class ConfigParamService {

    @Autowired
    ConfigParamMapper configParamMapper;
    /**
     * 查询所有配置数据
     */
    public List<ConfigParam> findAllConfig(){
        List<ConfigParam> list=configParamMapper.selectAll();
        ConfigParam param=new ConfigParam();
        list.add(param);
        return list;
    }
}
