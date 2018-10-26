package com.example.quickstart.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring boot 快速入门，简单的web请求处理示例
 *
 * @author zhouqiang
 */
@RestController
@RequestMapping(value="/springboot")
public class HelloWorldController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return "Welcome to spring-boot World !";
    }

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    public String sayHello(@PathVariable String name) {
        return name + ",Welcome to Spring-boot World";
    }
}