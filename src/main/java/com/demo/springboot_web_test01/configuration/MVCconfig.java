package com.demo.springboot_web_test01.configuration;

import com.demo.springboot_web_test01.interceptor.MyHandlerInterceptor;
import com.demo.springboot_web_test01.locale.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Joe
 * @version 1.0
 * @date 2020/3/18 13:53
 * 扩展springmvc功能
 */
@Configuration
public class MVCconfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        // 浏览器请求darling 来到index页面
        registry.addViewController("/darling").setViewName("index");
    }

   @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("main.html").setViewName("main");
            }
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new MyHandlerInterceptor()).addPathPatterns("/**").
                        excludePathPatterns("/darling", "/", "/index.html", "/user/login","/**.css");
            }

        };

        return webMvcConfigurer;
    }
    @Bean
    public MyLocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
