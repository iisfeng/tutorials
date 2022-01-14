package com.testeru.project;

import com.example.project.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description: 计算器用例设计
 * @Version 1.0
 * @create: 2022/1/12 1:52 下午
 */
public class Demo2Test {

    @BeforeEach
    void beforeEach(){
        System.out.println("计算器清零");
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
        System.out.println("填写计算结果");
    }

}
