package com.base.wang.web;

import com.base.wang.common.Global;
import com.base.wang.model.ConfigParam;
import com.base.wang.service.base.ConfigParamService;
import com.base.wang.util.StringUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

/**
 * 监听
 */
@WebListener
public class ConstantsServletContextListener implements ServletContextListener {

    /**
     *当服务启动时，读取BasConfigParam中的所有数据，存入全局常量中
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context=servletContextEvent.getServletContext();
        ApplicationContext ctx= WebApplicationContextUtils.getRequiredWebApplicationContext(context);
        ConfigParamService configParamService=(ConfigParamService)ctx.getBean("configParamService");
        List<ConfigParam> list = configParamService.findAllConfig();
        for(int i=0;i<list.size();i++){
            ConfigParam param=list.get(i);
            if(StringUtil.isEmptyOrNull(param.getCode()))continue;
            Global.CONFIG.put(param.getCode(),param.getValue());
            System.out.println("------->>>>>>>>>>>>>>"+param.getCode()+":::"+param.getValue());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
