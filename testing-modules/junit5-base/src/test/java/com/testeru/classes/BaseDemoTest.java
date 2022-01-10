package com.testeru.classes;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description:
 * @Version 1.0
 * @create: 2022/1/7 4:40 下午
 */
public class BaseDemoTest {
    @BeforeAll
    static void beforeAll(){
        System.out.println("---打开京东app---");
    }
    @BeforeEach
    void beforeEach(){
        System.out.println("---点击搜索按钮，跳转到搜索页面---");
    }
    @AfterEach
    void afterEach(){
        System.out.println("---返回app首页---");
    }
    @AfterAll
    static void afterAll(){
        System.out.println("---付款成功，生成订单号---");
    }
}
