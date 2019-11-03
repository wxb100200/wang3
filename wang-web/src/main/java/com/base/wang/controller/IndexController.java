package com.base.wang.controller;

import com.google.code.kaptcha.Constants;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@Api( description = "首页相关接口", tags = {"LoginController"})
public class IndexController {
    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("/")
    public String showHome(HttpServletRequest request) {
        System.out.println("----验证码："+request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY));
        return "login.html";
    }

   /* @GetMapping("/login")
    public String showLogin() {
        return "login.html";
    }

    @GetMapping("/admin")
    @ResponseBody
    @PreAuthorize("hasRole('role_admin')")
    public String printAdmin() {
        return "如果你看见这句话，说明你有ROLE_ADMIN角色";
    }

    @GetMapping("/user")
    @ResponseBody
    @PreAuthorize("hasRole('role_user')")
    public String printUser() {
        return "如果你看见这句话，说明你有ROLE_USER角色";
    }*/
}