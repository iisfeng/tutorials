package com.testeru.classes;

import com.testeru.base.MyClassTag;
import com.testeru.base.MyTag;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description: 1、基本注解 + 基础断言
 * @Version 1.0
 * @create: 2022/1/7 3:37 下午
 */
@MyClassTag
public class FirstDemoTest {
    @BeforeAll
    static void beforeAll(){
        System.out.println("---打开app/web网页---");

    }
    @BeforeEach
    void beforeEach(){
        System.out.println("---进入搜索页面---");

    }
    @Test
    void test1(){
        System.out.println("---输入搜索吃相关的关键字，进行搜索---");


        List<String> productList = Arrays.asList("紫薯","普洱","果冻橙");
        System.out.println("---获取搜索列表标题：" + productList);
        int num = 1;
        System.out.println("---点击查看搜索结果列表的第 " + num + " 个商品标题，进入商品详情页面---");

        String productText = "紫薯";
        System.out.println("---商品详情页获取对应商品标题：" + productText);

        System.out.println("---滑动商品详情页面---");

        assertEquals(productText,productList.get(num - 1));

    }
    @Test
    void test2(){
        System.out.println("---输入搜索电子相关的关键字，进行搜索---");

        List<String> productList = Arrays.asList("红米手机","iPhone11","荣耀");
        System.out.println("---获取搜索列表标题：" + productList);

        int num = 2;
        System.out.println("---点击查看搜索结果列表的第 " + num + " 个商品标题，进入商品详情页面---");
        String productText = "iPhone11";
        System.out.println("---商品详情页获取对应商品标题：" + productText);

        System.out.println("---滑动商品详情页面---");

        assertEquals(productText,productList.get(num - 1));

    }
    @AfterEach
    void afterEach(){
        System.out.println("---添加商品到购物车，返回app/web首页---");
    }
    @AfterAll
    static void afterAll(){
        System.out.println("---退出app/web---");
    }
}
