package com.demo.springboot_web_test01.locale;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author Joe
 * @version 1.0
 * @date 2020/3/18 16:21
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String l = httpServletRequest.getParameter("l");
//        String language = httpServletRequest.getHeader("Accept-Language");
        // 添加国际化信息,没有区域信息就用基础值
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(l)) {
            String[] mes = l.split("_");
            locale = new Locale(mes[0], mes[1]);
        }
        // 如果请求中没有信息参数，根据请求头配置国际化信息
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
