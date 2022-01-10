package com.testeru.classes;

import org.junit.jupiter.api.*;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description: 测试方法不是`@RepeatedTest`，则不能将`RepetitionInfo` 注入到 `@BeforeEach` 或 `@AfterEach` 方法中
 * @Version 1.0
 * @create: 2022/1/7 4:46 下午
 */
@DisplayName("junit5 test")
public class FiveDemoTest{

    @BeforeEach
    void beforeEach1(RepetitionInfo repetitionInfo){
        int currentRepetition = repetitionInfo.getCurrentRepetition();
        System.out.println("---搜索商品---" + currentRepetition);
    }
    @AfterEach
    void afterEach1(RepetitionInfo repetitionInfo){
        int currentRepetition = repetitionInfo.getCurrentRepetition();
        System.out.println("---添加购物车---"+ currentRepetition);
    }
    @DisplayName("four test")
    @RepeatedTest(value = 3,name = "重复搜索次数 {currentRepetition}/{totalRepetitions}")
    void test4(RepetitionInfo repetitionInfo) {
        int currentRepetition = repetitionInfo.getCurrentRepetition();
        System.out.println("第" + currentRepetition +"次搜索 查看第 " + currentRepetition + "个商品详情");
    }
    @DisplayName("third test")
    @Test
    void test3(){System.out.println("---点击查看第 2 个商品详情---");}
    @DisplayName("first test")
    @RepeatedTest(2)
    void test1(){
        System.out.println("---点击查看第 1 个商品详情---");
    }
}
