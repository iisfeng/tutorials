package com.testeru.springboot1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/***
 * springboot工程中都有一个启动引导类，这是工程入口类
 * 并在引导类上添加@SpringBootApplication
 * 扫描当前类及其子类
 */
@SpringBootApplication
public class SpringBoot1Application {

    public static void main(String[] args) {
        //启动引导类
        SpringApplication.run(SpringBoot1Application.class, args);

    }

}
