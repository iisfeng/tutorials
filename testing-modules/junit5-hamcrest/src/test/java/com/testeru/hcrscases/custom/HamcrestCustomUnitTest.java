package com.testeru.hcrscases.custom;

import org.junit.jupiter.api.Test;

import static com.testeru.hcrscases.custom.IsOnlyDigits.onlyDigits;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

/**
 * 除了内置匹配器，Hamcrest 还支持创建自定义匹配器
 */
public class HamcrestCustomUnitTest {

    @Test
    public final void givenAString_whenIsOnlyDigits_thenCorrect() {
        String digits = "123";

        assertThat(digits, is(onlyDigits()));
    }

    @Test
    public final void givenAString_whenIsNotOnlyDigits_thenCorrect() {
        String aphanumeric = "123ABC";

        assertThat(aphanumeric, is(not(onlyDigits())));
    }
//
//    @Test
//    public final void givenAString_whenIsUppercase_thenCorrect() {
//        String uppercaseWord = "HELLO";
//
//        assertThat(uppercaseWord, is(uppercase()));
//    }
//
//    @Test
//    public final void givenAnEvenInteger_whenDivisibleByTwo_thenCorrect() {
//        Integer ten = 10;
//        Integer two = 2;
//
//        assertThat(ten, is(divisibleBy(two)));
//    }
//
//    @Test
//    public final void givenAnOddInteger_whenNotDivisibleByTwo_thenCorrect() {
//        Integer eleven = 11;
//        Integer two = 2;
//
//        assertThat(eleven, is(not(divisibleBy(two))));
//    }
}
