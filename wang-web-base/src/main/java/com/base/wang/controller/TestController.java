package com.base.wang.controller;


import com.base.wang.common.PageReturn;
import com.base.wang.service.TestService;
import com.base.wang.service.base.RedisClientSingle;
import com.base.wang.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/test")
public class TestController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private TestService testService;
    @Autowired
    private RedisClientSingle jedisClientSingle;

    @GetMapping("/demo")
    public String test() {
        return "Hello World!";
    }

    @GetMapping("/findOne")
    public Object findOne() {
        return testService.findOne();
    }

    @GetMapping("/findTwo")
    public Object findTwo(Integer id) {
        return testService.selectByKey(id);
    }

    @GetMapping("/findThree")
    public Object findThree(Integer id) {
        return testService.findThree(id);
    }

    @GetMapping("/findFour")
    public Object findFour(Integer id) {
        return testService.findFour(id);
    }

    @GetMapping("/pageHelper")
    public Object pageHelper(String key, Integer pageNum,Integer pageSize) {
        if(pageNum==null) return PageReturn.fail("页码不能为空");
        if(pageSize==null) return PageReturn.fail("页面大小不能为空");
        return testService.pageHelper(key,pageNum,pageSize);
    }
    @GetMapping("/redis")
    public Object redis() {
        return jedisClientSingle.set("wang_redis", DateUtil.formatDateToString(new Date(),"yyyyMMddHHmmss"));
    }
    @GetMapping("/log")
    public Object log() {
        logger.info("---->>>>log info 日志");
        logger.debug("---->>>>log debug 日志");
        logger.error("---->>>>log error 日志");
        return PageReturn.success();
    }

}
