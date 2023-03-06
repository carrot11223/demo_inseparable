package com.example.demo_inseparable.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//继承WebMvcConfigurer扩展mvc
//用于往容器中添加组件，这里由于默认就是再static之下，我就没有用，注解注释起来了
//@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    /**
     * 资源映射路径
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");

    }
}


