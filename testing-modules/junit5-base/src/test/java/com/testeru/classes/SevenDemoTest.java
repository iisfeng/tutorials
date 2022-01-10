package com.testeru.classes;

import com.testeru.base.CustomOrder;
import org.junit.jupiter.api.*;


/**
 * @program: tutorials
 * @author: 盖盖
 * @description: 自定义排序规则测试
 * @Version 1.0
 * @create: 2022/1/7 4:46 下午
 */
@DisplayName("junit5 test")
@TestMethodOrder(CustomOrder.class)
public class SevenDemoTest extends BaseDemoTest{
    private static StringBuilder output = new StringBuilder("");

    @BeforeAll
    static void beforeAll1(){
        System.out.println("---进入到首页---");
    }
    @BeforeEach
    void beforeEach1(){
        System.out.println("---搜索商品---");
    }
    @DisplayName("first test:myaTest")
    @Test
    void myaTest(){
        System.out.println("---点击查看第 1 个商品详情---");
        output.append("下单日期为20220101\n");

    }
    @DisplayName("second test:myATest")
    @Disabled("先不执行")
    @Test
    void myATest(){
        System.out.println("---点击查看第 2 个商品详情---");
        output.append("下单日期为20220102\n");

    }
    @DisplayName("third test:myBTest")
    @Disabled
    @Test
    void myBTest(){
        System.out.println("---点击查看第 2 个商品详情---");
        output.append("下单日期为20220103\n");

    }
    @DisplayName("five test:mybTest")
    @RepeatedTest(value = 3,name = "Custom name {currentRepetition}/{totalRepetitions}")
    void mybTest(){
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
    @DisplayName("four test:myCTest")
    @RepeatedTest(value = 3,name = "重复搜索次数 {currentRepetition}/{totalRepetitions}")
    void myCTest(RepetitionInfo repetitionInfo) {
        int currentRepetition = repetitionInfo.getCurrentRepetition();
        System.out.println("第" + currentRepetition +"次搜索 查看第 " + currentRepetition + "个商品详情");
    }
}
