package com.base.wang.service.impl;

import com.base.wang.common.PageReturn;
import com.base.wang.mapper.BasTestMapper;
import com.base.wang.model.BasTest;
import com.base.wang.service.TestService;
import com.base.wang.service.base.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl  extends BaseServiceImpl<BasTest> implements TestService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private BasTestMapper basTestMapper;

    @Override
    public Object findOne() {
        return basTestMapper.selectByPrimaryKey(1);
    }

    @Override
    public Object findThree(Integer id) {
        return basTestMapper.selectByPrimaryKey(1);
    }

    @Override
    public Object findFour(Integer id) {
        logger.info("--->>>TestServiceImpl findFour id:"+id);
        BasTest basTest= basTestMapper.findById(id);
        return basTest;
    }

    /**
     * 分页查找数据
     */
    @Override
    public Object pageHelper(String key, Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<BasTest> testList=basTestMapper.findAll();
        PageInfo<BasTest> pageInfo = new PageInfo<>(testList);
        return PageReturn.successData(pageInfo);
    }
}
