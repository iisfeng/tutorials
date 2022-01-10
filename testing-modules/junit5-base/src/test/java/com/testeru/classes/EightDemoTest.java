package com.testeru.classes;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description:
 * @Version 1.0
 * @create: 2022/1/10 10:47 上午
 */
@DisplayName("第8个测试方法")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EightDemoTest {
    private static StringBuilder output = new StringBuilder("");

    @BeforeAll
    static void beforeAll1(){
        System.out.println("---进入到首页---");
    }
    @BeforeEach
    void beforeEach1(){
        System.out.println("---搜索商品---");
    }
    @DisplayName("first test")
    @Order(1)
    @ParameterizedTest
    @ValueSource(strings = {"1","2","8"})
    void test(String num){
        System.out.println("---点击查看第" + num + "个商品详情---");
        output.append("下单日期为20220101\n");

    }
    @DisplayName("second test")
    @Disabled("先不执行")
    @Test
    @Order(2)
    void test2(){
        System.out.println("---点击查看第 2 个商品详情---");
        output.append("下单日期为20220102\n");

    }
    @DisplayName("third test")
    @Disabled
    @Test
    @Order(3)
    void test3(){
        System.out.println("---点击查看第 2 个商品详情---");
        output.append("下单日期为20220103\n");

    }
    @DisplayName("six test")
    @RepeatedTest(value = 3,name = "6 {currentRepetition}/{totalRepetitions}")
    @Order(5)
    @ParameterizedTest
    @ValueSource(strings = {"1","2","8"})
    void test6(String num){
        System.out.println("---点击查看第" + num + "个商品详情---");
        output.append("下单日期为20220109\n");
    }

    @DisplayName("five test")
    @RepeatedTest(value = 3,name = "Custom name {currentRepetition}/{totalRepetitions}")
    @Order(9)
    void test5(){
        System.out.println("---点击查看第 6 个商品详情---");
        output.append("下单日期为20220109\n");
    }
    @AfterEach
    void afterEach1(){

        System.out.println("---添加购物车---");
    }
    @AfterAll
    static void afterAll1(){
        System.out.println("---进入购物车列表，生成订单，进行订单付款---");
        System.out.println(output.toString());
    }
    @DisplayName("four test")
    @RepeatedTest(value = 3,name = "重复搜索次数 {currentRepetition}/{totalRepetitions}")
    void test4(RepetitionInfo repetitionInfo) {
        int currentRepetition = repetitionInfo.getCurrentRepetition();
        System.out.println("第" + currentRepetition +"次搜索 查看第 " + currentRepetition + "个商品详情");
    }
    @DisplayName("seven test")
    @Order(99)
    @ParameterizedTest
    @ValueSource(ints = {20220109,20220109,20220109})
    void test7(String num){
        System.out.println("---点击查看第" + num + "个商品详情---");
        output.append("下单日期为20220101\n");
    }
    @DisplayName("eight test")
    @Order(98)
    @ParameterizedTest
    @ValueSource(ints = {20220109,20220109,20220109})
    void test8(int date){
        System.out.println("---点击查看第 8 个商品详情---");
        System.out.println("下单日期为：" + date + "\n");
        output.append("下单日期为：" + date + "\n");
    }
}
