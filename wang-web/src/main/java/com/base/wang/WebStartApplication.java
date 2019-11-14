package com.base.wang;


import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;
@SpringBootApplication
@ServletComponentScan
@EnableScheduling
@MapperScan("com.base.wang.mapper")
public class WebStartApplication {


    private static String YML_PATH = "application.yml";
    private static String YML_PATH_TEST = "/home/wang/properties/wang_test.yml";
    private static String YML_PATH_PROD = "/home/wang/properties/wang_prod.yml";

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocalOverride(true);
        if (getYmlResource() != null) {
            YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
            yaml.setResources(getYmlResource());
            configurer.setProperties(yaml.getObject());
        }
        return configurer;
    }

    private static Resource getYmlResource() {
        FileSystemResource fileSystemResource = new FileSystemResource(YML_PATH_PROD);
        if (fileSystemResource.exists()) {
            return fileSystemResource;
        }
        fileSystemResource = new FileSystemResource(YML_PATH_TEST);
        if (fileSystemResource.exists()) {
            return fileSystemResource;
        }
        ClassPathResource classPathResource = new ClassPathResource(YML_PATH);
        if (classPathResource.exists()) {
            return classPathResource;
        }
        return null;
    }

    public static void main(String[] args) {
        SpringApplication.run(WebStartApplication.class, args);
    }
}
