package com.testeru.base;

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

}