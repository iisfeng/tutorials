package com.testeru.classes;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description: 参数化@MethodSource 声明方法名 单个参数
 * @Version 1.0
 * @create: 2022/1/10 10:47 上午
 */
@DisplayName("第9个测试用例")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NineDemoTest {
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

    @DisplayName("nine test")
    @Order(97)
    @ParameterizedTest
//    @NullSource
//    @EmptySource
    @NullAndEmptySource
    @ValueSource(strings = {"2","9","19"})
    void test9(String num){
        System.out.println("---点击查看第 " + num + " 个商品详情---");
        output.append("下单日期为20220109\n");
    }

    @DisplayName("ten test")
    @Order(96)
    @ParameterizedTest
    //只需要一个参数
    //声明指定参数的方法名
    @MethodSource("intDate1")
    void test10(int date){
        System.out.println("---点击查看第 10 个商品详情---");
        System.out.println("下单日期为：" + date + "\n");
        output.append("下单日期为：" + date + "\n");
    }
    //使用的是包装类
    static Stream<Integer> intDate1() {
        return Stream.of(20220109,20220119,20220122);
    }
    static List<Integer> intDate2(){
        return Arrays.asList(20220209,20220219,20220222);
    }
    static IntStream intDate3(){
        return IntStream.of(20220309,20220319,20220322);
    }
    static int[] intDate4(){
        return new int[]{20220409,20220419,20220422};
    }


    @DisplayName("eleven test")
    @Order(95)
    @ParameterizedTest
    @MethodSource("strData3")
    void test11(String num){
        System.out.println("---点击查看第 " + num + " 个商品详情---");
        output.append("下单日期为20220209\n");
    }

    static String[] strData1(){
        return new String[]{"2","6","8"};
    }
    static List<String> strData2(){
        return Arrays.asList("12","16","18");
    }
    static Stream<String> strData3(){
        return Stream.of("22","26","28");
    }

}
