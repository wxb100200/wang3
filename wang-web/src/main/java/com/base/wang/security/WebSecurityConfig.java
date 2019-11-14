package com.base.wang.security;

import com.base.wang.common.PageReturn;
import com.base.wang.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private TokenFilter tokenFilter;
    @Override
    public void configure(WebSecurity web) throws Exception {
        // 设置拦截忽略文件夹，可以对静态资源放行
        web.ignoring().antMatchers("/static/**","/favicon.ico","/login.html");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 关闭CSRF跨域
        http.csrf().disable();
        // 基于token，所以不需要session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests()
                .antMatchers( "/","/user/login","/user/getKaptchaImage")
                .permitAll().anyRequest().authenticated();
        http.formLogin().and().exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);//未登录认证
        // 解决不允许显示在iframe的问题
        http.headers().frameOptions().disable();
        http.headers().cacheControl();

        http.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    /**
     * 未登录
     * 如果后缀是.html跳转首页，否则提示消息
     */
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return (request, response, authException) -> {
            String url = request.getRequestURI();
            if (url.endsWith(".html")) {
                response.sendRedirect("/");
            } else {
                ResponseUtil.responseJson(response, HttpStatus.UNAUTHORIZED.value(), PageReturn.fail("请先登录"));
            }
        };
    }
}