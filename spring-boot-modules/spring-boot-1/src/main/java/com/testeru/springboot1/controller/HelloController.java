package com.testeru.springboot1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description:
 * @Version 1.0
 * @create: 2022/1/13 4:29 下午
 */
/**   @RestController
 * 组合@Controller +@ResponseBody 进行注解
 * 控制器
 */

@RestController
public class HelloController {
    //注入
    @Autowired
    private DataSource dataSource;
    //处理前端发过来的请求
//    @RequestMapping(value="/hello",method = GET)
    @GetMapping("hello")
    public String hello(){
        String s = "Hello,Spring Boot";
        System.out.println(s);
        System.out.println("dataSource:"+dataSource);
        return s;
    }
}
