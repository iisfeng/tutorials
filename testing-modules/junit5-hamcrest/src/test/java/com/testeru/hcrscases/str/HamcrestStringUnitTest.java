package com.testeru.hcrscases.str;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.*;
import static org.hamcrest.core.StringEndsWith.*;
import static org.hamcrest.core.StringStartsWith.*;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description:
 * @Version 1.0
 * @create: 2021/12/24 6:38 下午
 */
public class HamcrestStringUnitTest {

    @Test
    void UsingIsForMatch(){
        String testString = "Rhaegar Targaryen";
        //我们可以使用 containsString(String) 或 containsStringIgnoringCase(String) 来断言实际字符串是否包含测试字符串
        assertThat(testString, containsString("aegar"));
        assertThat(testString, containsStringIgnoringCase("AEGAR"));

        //或者 startsWith(String) 和 startsWithIgnoringCase(String) 断言实际字符串是否以测试字符串开头
        assertThat(testString, startsWith("Rhae"));
        assertThat(testString, startsWithIgnoringCase("rhae"));

        //我们还可以使用endsWith(String) 或endsWithIgnoringCase(String) 来断言实际字符串是否以测试字符串结尾
        assertThat(testString, endsWith("aryen"));
        assertThat(testString, endsWithIgnoringCase("ARYEN"));
    }
}
