package com.testeru.params;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;

import java.lang.reflect.Field;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description:
 * @Version 1.0
 * @create: 2022/1/10 4:57 下午
 */

/**
 * AnnotationConsumer 是一个用于消费注解的函数式接口。
 * 它通常由 ArgumentsProvider 和 ArgumentConverter 的实现来实现，以表明它们可以接受某个注释
 */
public class VariableArgumentsProvider
        implements ArgumentsProvider, AnnotationConsumer<VariableSource> {

    private String variableName;

    @Override
    public void accept(VariableSource variableSource) {
        this.variableName = variableSource.value();
    }


    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        Object testInstance = context.getTestInstance().orElse(null);
        return context.getTestClass()
                .map(this::getField)
                .map(this::getValue)
                .orElseThrow(() ->
                        new IllegalArgumentException("Failed to load test arguments"));
    }



    @Override
    public Consumer<VariableSource> andThen(Consumer<? super VariableSource> after) {
        return AnnotationConsumer.super.andThen(after);
    }

    private Field getField(Class<?> clazz) {

        try {
            return clazz.getDeclaredField(variableName);
        } catch (Exception e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    private Stream<Arguments> getValue(Field field) {
        Object value = null;
        try {
            value = field.get(null);
            System.out.println("value:"+value);
        } catch (Exception ignored) {
            System.out.println("value:"+value);

        }

        return value == null ? null : (Stream<Arguments>) value;
    }

}