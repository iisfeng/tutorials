package com.testeru.base;

import com.example.project.Calculator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description:
 * @Version 1.0
 * @create: 2022/1/13 11:06 上午
 */
public class BaseTest {
    public Calculator calculator;

    @BeforeAll
    public static void initForAllTest(){

    }
    @AfterAll
    public static void cleanupForAllTest(){
        System.out.println("退出计算器app");
    }
    @AfterEach
    void afterEach(){
        //保持数据清空
        System.out.println("用例结束，返回标准计算器");

    }
    @BeforeEach
    public void initTest()
    {
        calculator = new Calculator();
        System.out.println("打开计算器app");
    }

}
