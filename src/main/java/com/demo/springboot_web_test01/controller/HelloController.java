package com.demo.springboot_web_test01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

/**
 * @author Joe
 * @version 1.0
 * @date 2020/3/16 16:47
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map) {
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("s1","s2","s3"));
        return "success";
    }

    @RequestMapping("/login")
    public String index() {

        return "index";
    }
}
