package com.testeru.base;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: tutorials
 * @author: ηη
 * @description:
 * @Version 1.0
 * @create: 2022/1/12 5:25 δΈε
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Tag("mytag")
@Test
public @interface MyTag {
}