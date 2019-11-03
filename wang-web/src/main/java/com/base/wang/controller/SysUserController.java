package com.base.wang.controller;

import com.alibaba.fastjson.JSONObject;
import com.base.wang.common.PageReturn;
import com.base.wang.model.SysUser;
import com.base.wang.security.TokenFilter;
import com.base.wang.security.UserUtil;
import com.base.wang.service.SysTokenService;
import com.base.wang.service.SysUserService;
import com.base.wang.util.StringUtil;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/user")
@Api(value = "/user", description = "用户相关接口", tags = {"SysUserController"})
public class SysUserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SysUserService userService;
    @Autowired
    private SysTokenService tokenService;

    @ApiOperation("用户登录")
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", dataType = "String",  paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "codeNum", value = "验证码", dataType = "String",  paramType = "query"),
    })
    public PageReturn login(String username, String password, String codeNum,
                                 HttpServletRequest request, HttpServletResponse response) {
        if(StringUtil.isEmpty(username))return PageReturn.fail("用户名不能为空");
        if(StringUtil.isEmpty(password))return PageReturn.fail("密码不能为空");
        if(StringUtil.isEmpty(codeNum))return PageReturn.fail("验证码不能为空");
        String code=(String)request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if(!code.toLowerCase().equals(codeNum.toLowerCase())){
            logger.info("---->>>SysUserController login 验证码为："+code+",用户输入的验证码为："+codeNum);
            return PageReturn.fail("图片验证码不符");
        }
        // 从数据库中取出用户信息
        SysUser user = userService.selectByName(username);
        // 判断用户是否存在
        if(user == null) return PageReturn.fail("用户名不存在");
        String token=tokenService.saveToken(user);
        Cookie cookie=new Cookie("token",token);
        cookie.setPath("/");
        response.addCookie(cookie);
        return PageReturn.successData(user);
    }
    @ApiOperation("用户退出")
    @RequestMapping(value = "/logout", method = {RequestMethod.GET, RequestMethod.POST})
    public PageReturn logout(HttpServletRequest request, HttpServletResponse response) {
        SysUser loginUser= UserUtil.getLoginUser();
        logger.info("---->>>>loginUser"+ JSONObject.toJSONString(loginUser));
        String token = TokenFilter.getToken(request);
        tokenService.deleteToken(token);
        return PageReturn.success("退出成功");
    }
    /**
     * 获取验证码
     */
    @Autowired
    private Producer captchaProducer;
    @GetMapping("/getKaptchaImage")
    public void getKaptchaImage(HttpServletRequest request,HttpServletResponse response) throws Exception {
        response.setDateHeader("Expires", 0);
        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");
        // return a jpeg
        response.setContentType("image/jpeg");
        // create the text for the image
        String capText = captchaProducer.createText();
        // store the text in the session
        //request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        //将验证码存到session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        logger.info("-------->>>>SysUserController getKaptchaImage code:"+capText);
        // create the image with the text
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        // write the data out
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }
}
