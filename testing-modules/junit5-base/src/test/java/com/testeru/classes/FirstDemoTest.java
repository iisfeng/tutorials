package com.testeru.classes;

import org.junit.jupiter.api.*;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description:
 * @Version 1.0
 * @create: 2022/1/7 3:37 下午
 */
public class FirstDemoTest {
    @BeforeAll
    static void beforeAll(){
        System.out.println("---打开搜索页面---");
    }
    @BeforeEach
    void beforeEach(){
        System.out.println("---搜索商品---");
    }
    @Test
    void test(){
        System.out.println("---点击查看第 1 个商品详情---");
    }
    @Test
    void test2(){
        System.out.println("---点击查看第 2 个商品详情---");
    }
    @AfterEach
    void afterEach(){
        System.out.println("---添加购物车---");
    }
    @AfterAll
    static void afterAll(){
        System.out.println("---进行订单付款---");
    }
}
