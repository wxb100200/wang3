package com.base.wang.service;

import com.base.wang.model.BasTest;
import com.base.wang.service.base.BaseService;

public interface TestService extends BaseService<BasTest> {
    Object findOne();

    Object findThree(Integer id);

    Object findFour(Integer id);

    Object pageHelper(String key, Integer pageNum,Integer pageSize);
}
