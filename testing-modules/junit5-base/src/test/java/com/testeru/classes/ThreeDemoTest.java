package com.testeru.classes;

import org.junit.jupiter.api.*;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description: 执行顺序
 * @Version 1.0
 * @create: 2022/1/7 4:46 下午
 */
public class ThreeDemoTest extends BaseDemoTest{
    @BeforeAll
    static void beforeAll1(){
        System.out.println("---进入到首页---");
    }
    @BeforeEach
    void beforeEach1(){
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
    void afterEach1(){
        System.out.println("---添加购物车---");
    }
    @AfterAll
    static void afterAll1(){
        System.out.println("---进入购物车列表，生成订单，进行订单付款---");
    }
}
