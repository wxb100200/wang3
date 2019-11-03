package com.base.wang.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * 验证码配置
 */
@Configuration
public class KaptchaConfig {

    @Bean(name="captchaProducer")
    public DefaultKaptcha getKaptchaBean(){
        DefaultKaptcha defaultKaptcha=new DefaultKaptcha();
        Properties properties=new Properties();
        properties.setProperty("kaptcha.border", "yes");//是否有边框
        properties.setProperty("kaptcha.border.color", "105,179,90");//边框颜色
        properties.setProperty("kaptcha.image.width", "130");//图片宽度
        properties.setProperty("kaptcha.image.height", "50");//图片高度
        properties.setProperty("kaptcha.session.key", "code");
//        properties.setProperty("kaptcha.noise.impl", "com.google.code.kaptcha.impl.NoNoise");//无干扰线
        properties.setProperty("kaptcha.noise.color", "red");//干扰线颜色
        properties.setProperty("kaptcha.textproducer.char.string", "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789");//使用哪些字符生成验证码
        properties.setProperty("kaptcha.textproducer.char.length", "4");//字符个数
        properties.setProperty("kaptcha.textproducer.font.color", "blue");//字体颜色
        properties.setProperty("kaptcha.textproducer.font.names", "Arial");//使用那些字体  Arial 宋体,楷体,微软雅黑
        properties.setProperty("kaptcha.textproducer.font.size", "50");//字体大小
        properties.setProperty("kaptcha.textproducer.char.space", "3");//字体间隔
        Config config=new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
