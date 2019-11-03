package com.base.wang.controller;


import com.base.wang.common.PageReturn;
import com.base.wang.service.TestService;
import com.base.wang.service.base.RedisClientSingle;
import com.base.wang.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/test")
@Api(value = "/test", description = "测试相关接口", tags = {"TestController"})
public class TestController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private TestService testService;
    @Autowired
    private RedisClientSingle jedisClientSingle;

    @ApiOperation("demo测试")
    @GetMapping("/demo")
    public String test() {
        return "Hello World!";
    }

    @ApiOperation("查找数据测试")
    @GetMapping("/findOne")
    public Object findOne() {
        return testService.findOne();
    }

    @ApiOperation("查找数据测试二")
    @GetMapping("/findTwo")
    @ApiImplicitParam(name = "id", value = "测试记录id", required = true, dataType = "int", paramType = "query")
    public Object findTwo(Integer id) {
        return testService.selectByKey(id);
    }

    @ApiOperation("查找数据测试三")
    @GetMapping("/findThree")
    @ApiImplicitParam(name = "id", value = "测试记录id", required = true, dataType = "int", paramType = "query")
    public Object findThree(Integer id) {
        return testService.findThree(id);
    }

    @ApiOperation("查找数据测试四")
    @GetMapping("/findFour")
    @ApiImplicitParam(name = "id", value = "测试记录id", required = true, dataType = "int", paramType = "query")
    public Object findFour(Integer id) {
        return testService.findFour(id);
    }

    @ApiOperation("分页查找数据")
    @GetMapping("/pageHelper")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "收索关键字", dataType = "String",  paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "int", required = true, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页面大小", dataType = "int", required = true, paramType = "query"),
    })
    public Object pageHelper(String key, Integer pageNum,Integer pageSize) {
        if(pageNum==null) return PageReturn.fail("页码不能为空");
        if(pageSize==null) return PageReturn.fail("页面大小不能为空");
        return testService.pageHelper(key,pageNum,pageSize);
    }
    @ApiOperation("redis测试")
    @GetMapping("/redis")
    public Object redis() {
        return jedisClientSingle.set("wang_redis", DateUtil.formatDateToString(new Date(),"yyyyMMddHHmmss"));
    }
    @ApiOperation("log日志")
    @GetMapping("/log")
    public Object log() {
        logger.info("---->>>>log info 日志");
        logger.debug("---->>>>log debug 日志");
        logger.error("---->>>>log error 日志");
        return PageReturn.success();
    }

}
