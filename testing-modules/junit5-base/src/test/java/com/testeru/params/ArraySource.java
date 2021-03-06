package com.testeru.params;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: tutorials
 * @author: ηη
 * @description:
 * @Version 1.0
 * @create: 2022/1/10 6:07 δΈε
 */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ArraySource {
    int[] array() default {};
}