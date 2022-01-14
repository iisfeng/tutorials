package com.testeru.base;

import com.testeru.util.StringsUtils;
import org.junit.jupiter.api.MethodDescriptor;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrdererContext;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Optional;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description:
 * @Version 1.0
 * @create: 2022/1/12 5:01 下午
 */
public class SelfOrder implements MethodOrderer {
    @Override
    public void orderMethods(MethodOrdererContext context) {
        context.getMethodDescriptors().sort(
                (MethodDescriptor m1, MethodDescriptor m2)->
                {
                    String name1 = m1.getMethod().getName();
                    String name2 = m2.getMethod().getName();
                    Integer num1 = StringsUtils.num(name1);
                    Integer num2 = StringsUtils.num(name2);
                    System.out.println(num1);
                    System.out.println(num2);
                    return num1.compareTo(num2);

                });

    }

    @Override
    public Optional<ExecutionMode> getDefaultExecutionMode() {
        return MethodOrderer.super.getDefaultExecutionMode();
    }
}
