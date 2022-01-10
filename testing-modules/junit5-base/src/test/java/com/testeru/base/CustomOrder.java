package com.testeru.base;

import org.junit.jupiter.api.MethodDescriptor;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrdererContext;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Optional;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description: 通过实现MethodOrderer接口来使用我们自己的自定义订单
 * 根据测试名称以不区分大小写的字母数字顺序对测试进行排序
 * @Version 1.0
 * @create: 2022/1/9 5:47 下午
 */
public class CustomOrder implements MethodOrderer {
    @Override
    public void orderMethods(MethodOrdererContext context) {
        //context.getMethodDescriptors():[DefaultMethodDescriptor [method = 'void com.testeru.classes.SevenDemoTest.myATest()'], DefaultMethodDescriptor [method = 'void com.testeru.classes.SevenDemoTest.myBTest()'], DefaultMethodDescriptor [method = 'void com.testeru.classes.SevenDemoTest.myCTest(org.junit.jupiter.api.RepetitionInfo)'], DefaultMethodDescriptor [method = 'void com.testeru.classes.SevenDemoTest.myaTest()'], DefaultMethodDescriptor [method = 'void com.testeru.classes.SevenDemoTest.mybTest()']]
        System.out.println("context.getMethodDescriptors():" + context.getMethodDescriptors());

        context.getMethodDescriptors().sort(

                //MethodDescriptor 获取当前method
                (MethodDescriptor m1, MethodDescriptor m2)-> {
                        // compareToIgnoreCase()    按字典顺序比较两个字符串，忽略大小写差异

                    System.out.println("m1.getMethod().getName():"+ m1.getMethod().getName());
                    System.out.println("m2.getMethod().getName():"+ m2.getMethod().getName());
                    System.out.println(m1.getMethod().getName().compareToIgnoreCase(m2.getMethod().getName()));
                    System.out.println("-------------------------");
                    return m1.getMethod().getName().compareToIgnoreCase(m2.getMethod().getName());
                }
                );
    }

    @Override
    public Optional<ExecutionMode> getDefaultExecutionMode() {
        return MethodOrderer.super.getDefaultExecutionMode();
    }
}
