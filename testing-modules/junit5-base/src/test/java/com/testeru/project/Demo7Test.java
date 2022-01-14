package com.testeru.project;

import com.example.project.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description: 顺序执行
 * @Version 1.0
 * @create: 2022/1/12 1:52 下午
 */
@DisplayName("第7个计算器用例😊")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Demo7Test {


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
    @Order(16)
    @DisplayName("加法用例")
    void test1(){
        System.out.println("加法用例");
        int add = calculator.add(1, 5);
        System.out.println("计算结果比对");
        assertEquals(6,add);
    }

    @Test
    @Order(13)
    @DisplayName("减法用例")
    void test2(){
        System.out.println("减法用例");
        int add = calculator.sub(1, 5);
        System.out.println("计算结果比对");
        assertEquals(-4,add);
    }


    @Test
    @Order(6)
    @DisplayName("乘法用例")
    void test3(){
        System.out.println("乘法用例");
        int add = calculator.mul(1, 5);
        System.out.println("计算结果比对");
        assertEquals(5,add);
    }

    @Test
    @Order(1)
    @DisplayName("除法用例")
    void test4(){
        System.out.println("除法用例");
        int add = calculator.div(10, 5);
        System.out.println("计算结果比对");
        assertEquals(2,add);
    }



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