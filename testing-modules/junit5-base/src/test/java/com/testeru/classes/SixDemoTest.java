package com.testeru.classes;

import com.testeru.base.BaseDemoTest;
import org.junit.jupiter.api.*;


/**
 * @program: tutorials
 * @author: 盖盖
 * @description: Order排序
 * @Version 1.0
 * @create: 2022/1/7 4:46 下午
 */
@DisplayName("junit5 test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SixDemoTest extends BaseDemoTest {
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
    @Test
    @Order(1)
    void test(){
        System.out.println("---点击查看第 1 个商品详情---");
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
}
