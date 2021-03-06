package com.testeru.base;

import org.apiguardian.api.API;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import java.lang.annotation.*;

import static org.apiguardian.api.API.Status.STABLE;

/**
 * @program: tutorials
 * @author: ηη
 * @description:
 * @Version 1.0
 * @create: 2022/1/12 5:25 δΈε
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Tag("mytag")
@Documented
//@Inherited
public @interface MyClassTag {
}