package com.testeru.params;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description:
 * @Version 1.0
 * @create: 2022/1/10 6:05 下午
 */
public class ArrayArgumentsProvider implements ArgumentsProvider, AnnotationConsumer<ArraySources> {


    private List<int[]> arguments;

    @Override
    public void accept(ArraySources source) {
        List<ArraySource> arrays = Arrays.asList(source.arrays());
        this.arguments = arrays.stream().map(ArraySource::array).collect(Collectors.toList());
        System.out.println(this.arguments);
    }
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

        return this.arguments.stream().map(Arguments::of);
    }
}
