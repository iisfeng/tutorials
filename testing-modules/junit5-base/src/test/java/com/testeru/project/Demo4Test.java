package com.testeru.project;

import com.example.project.Calculator;
import com.testeru.base.BaseTest;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description: 计算器用例设计 - 多个beforeAll  运行顺序
 * @Version 1.0
 * @create: 2022/1/12 1:52 下午
 */
public class Demo4Test extends BaseTest {

    @BeforeAll
    static void beforeAll(){
        System.out.println("打开计算器app");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("Demo4Test 计算器清零");
    }

    //直接写test测试
    @Test
    void test1(){
        System.out.println("加法用例");
        Calculator calculator = new Calculator();
        int add = calculator.add(1, 5);
        System.out.println("计算结果比对");
        assertEquals(6,add);
    }

    @Test
    void test2(){
        System.out.println("减法用例");
        Calculator calculator = new Calculator();
        int add = calculator.sub(1, 5);
        System.out.println("计算结果比对");
        assertEquals(-4,add);
    }

    @AfterEach
    void afterEach(){
        //保持数据清空
        System.out.println("用例结束，返回标准计算器");    }
    @AfterAll
    static void afterAll(){
        System.out.println("退出计算器app");
    }
}
