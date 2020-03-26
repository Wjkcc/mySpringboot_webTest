package com.demo.springboot_web_test01.configuration;

import com.demo.springboot_web_test01.servlet.MyServlet;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Joe
 * @version 1.0
 * @date 2020/3/26 15:03
 */
@Configuration
public class MyServerConig {

    @Bean
    public ServletRegistrationBean<MyServlet> servletServletRegistrationBean() {
        return new ServletRegistrationBean<MyServlet>(new MyServlet(),"/ss");
    }

    @Bean
    public WebServerFactoryCustomizer webServerFactoryCustomizer() {
//        return new WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>() {
//            @Override
//            public void customize(ConfigurableServletWebServerFactory  factory) {
//                factory.setPort(8090);
//            }
//        };
        WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> w =
                (ConfigurableServletWebServerFactory factory) -> {
                    factory.setPort(8090);
                };
        return w;
    }
}
