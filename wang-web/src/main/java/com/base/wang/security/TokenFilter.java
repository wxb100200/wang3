package com.base.wang.security;

import com.alibaba.fastjson.JSONObject;
import com.base.wang.model.SysToken;
import com.base.wang.model.SysUser;
import com.base.wang.service.SysTokenService;
import com.base.wang.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
public class TokenFilter extends OncePerRequestFilter {
    public static final String TOKEN_KEY = "token";
    private static final Long MINUTES_10 = 10 * 60 * 1000L;
    @Autowired
    private SysTokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        String token=getToken(request);
        if (!StringUtil.isEmpty(token)) {
            SysToken sysToken=tokenService.findValidToken(token);
            if(sysToken!=null){
                sysToken=checkExpireTime(sysToken);
                String value=sysToken.getValue();
                System.out.println("token value:"+value);
                SysUser loginUser= JSONObject.parseObject(value,SysUser.class);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(loginUser,
                        null, loginUser.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        chain.doFilter(request,response);

    }

    /**
     * 检测有效时间
     * 如果有效时间临近10分钟，延长有效时间
     */
    private SysToken checkExpireTime(SysToken sysToken) {
        Date expireTime=sysToken.getExpireTime();
        Date now=new Date();
        if((expireTime.getTime()-now.getTime())<=MINUTES_10){
            sysToken=tokenService.extendExpireTime(sysToken.getId());
        }
        return sysToken;
    }

    //获取令牌
    public static String getToken(HttpServletRequest request) {
        String token = request.getParameter(TOKEN_KEY);
        if (StringUtils.isEmpty(token)) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (TOKEN_KEY.equals(cookie.getName())) {
                        token = cookie.getValue();
                        break;
                    }
                }
            }
        }
        if (StringUtils.isEmpty(token)) {
            token = request.getHeader(TOKEN_KEY);
        }
        return token;
    }
}
