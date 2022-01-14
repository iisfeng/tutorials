package com.testeru.project;

import com.example.project.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description: DisplayName、Disabled
 * @Version 1.0
 * @create: 2022/1/12 1:52 下午
 */
@DisplayName("第6个计算器用例😊")
public class Demo6Test {

    static Calculator calculator;
    @BeforeAll
    static void beforeAll(){
        System.out.println("打开计算器app");
        calculator = new Calculator();
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("进入科学计算器，计算器清零");

    }
    //直接写test测试
    @Test
    @DisplayName("加法用例")
    void test1(){
        System.out.println("加法用例");
        int add = calculator.add(1, 5);
        System.out.println("计算结果比对");
        assertEquals(6,add);
    }

    @Test
    @DisplayName("减法用例")
    void test2(){
        System.out.println("减法用例");
        int add = calculator.sub(1, 5);
        System.out.println("计算结果比对");
        assertEquals(-4,add);
    }


    @Disabled
    @Test
    @DisplayName("乘法用例")
    void test3(){
        System.out.println("乘法用例");
        int add = calculator.mul(1, 5);
        System.out.println("计算结果比对");
        assertEquals(5,add);
    }

    @Disabled("先不计算除法")
    @Test
    @DisplayName("除法用例")
    void test4(){
        System.out.println("除法用例");
        int add = calculator.div(10, 5);
        System.out.println("计算结果比对");
        assertEquals(2,add);
    }



    @RepeatedTest(10)
    @DisplayName("持续增用例")
    void test5() throws InterruptedException {
        System.out.println("持续增用例");
        int result = calculator.add(6);
        System.out.println("计算结果比对" + result);
//        assertEquals(6,result);
    }
    @RepeatedTest(value = 10,name = " {currentRepetition} / {totalRepetitions}")
    @DisplayName("持续增用例")
    void test6(RepetitionInfo repetitionInfo) throws InterruptedException {

        int currentRepetition = repetitionInfo.getCurrentRepetition();
        System.out.println("持续增用例:"+currentRepetition);
        int result = calculator.add(currentRepetition);

        int expected = currentRepetition;
        System.out.println("计算结果比对" + result);
        assertEquals(6,result);
    }

//    @RepeatedTest


    @AfterEach
    void afterEach(){
        //保持数据清空
        System.out.println("用例结束，返回标准计算器");

    }
    @AfterAll
    static void afterAll(){
        System.out.println("退出计算器app");
    }
}
