package com.testeru.base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description:
 * @Version 1.0
 * @create: 2021/12/27 3:18 下午
 */
public class BaseTest {
    public void get(){
        //获取当前类名
        String name = new Exception().getStackTrace()[1].getClassName(); //获取调用者的类名

        //获取调用者的方法名
        String methodName = new Exception().getStackTrace()[1].getMethodName();
        System.out.println(name+"："+methodName);
    }
    @BeforeAll
    static void baseBeforeAll(){
        System.out.println("手机搜索找到计算器app");
    }

    @BeforeEach
    void baseBeforeEach(){
        System.out.println("计算器清零");
    }

    @AfterEach
    void baseAfterEach(){
        System.out.println("记录计算结果");
    }
    @AfterAll
    static void baseAfterAll(){
        System.out.println("手机锁屏");

    }
}