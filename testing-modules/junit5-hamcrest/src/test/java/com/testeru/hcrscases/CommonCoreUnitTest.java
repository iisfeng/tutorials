package com.testeru.hcrscases;

import com.testeru.hcrscases.entity.City;
import com.testeru.hcrscases.entity.Location;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description: 1、常见的核心匹配器
 * @Version 1.0
 * @create: 2021/12/24 5:30 下午
 */
public class CommonCoreUnitTest {
    /**
     * is(T)和is(Matcher<T>)
     * is(T) 将一个对象作为参数来检查相等性
     * is(Matcher<T>) 使用另一个匹配器，使相等性语句更具表现力
     */
    @Test
    void UsingIsForMatch(){
        String testString = "hamcrest core Is match";

        assertThat(testString, is("hamcrest core Is match"));
        assertThat(testString, is(equalTo("hamcrest core Is match")));
    }
    /**
     * equalTo(T)
     * equalTo(T) 将一个对象作为参数并检查其与另一个对象的相等性。这经常与 is(Matcher<T>) 一起使用
     */
    @Test
    void UsingEqualToForMatch(){
        String actualString = "equalTo match";
        Object original = 100;

        assertThat(actualString, is(equalTo("equalTo match")));
        //1、对应数组长度前后相同
        //2、在相同的索引下包含的内容相同
        List<String> actualList = Arrays.asList("equalTo", "match");
        assertThat(actualList, is(equalTo(Arrays.asList("equalTo", "match"))));
        assertThat(original, equalToObject(100));
    }
    /**
     * not(T) and not(Matcher<T>)
     * 用于检查给定对象的不相等性。首先接受一个对象作为参数，然后接受另一个匹配器
     */
    @Test
    void UsingNotForMatch(){
        String testString = "hamcrest not match";

        assertThat(testString, not("hamcrest other match"));
        assertThat(testString, is(not(equalTo("hamcrest other match"))));
        assertThat(testString, is(not(instanceOf(Integer.class))));

    }

    /**
     * is(nullValue())
     * nullValue() and nullValue(Class<T>)
     * nullValue() 针对检查的对象检查空值。 nullValue(Class<T>) 检查给定类类型对象的可空性
     */
    @Test
    void UsingNullValueForMatch(){
        Integer nullObject = null;

        assertThat(nullObject, is(nullValue()));
        assertThat(nullObject, is(nullValue(Integer.class)));
        String nullObject1 = null;
        assertThat(nullObject1, is(nullValue(String.class)));


    }
    /**
     * notNullValue() and notNullValue(Class<T>)
     * 这些是常用 is(not(nullValue)) 的快捷方式。这些检查对象或类类型的非空相等性
     */
    @Test
    void UsingNotNullValueForMatch(){
        Integer testNumber = 123;

        assertThat(testNumber, is(notNullValue()));
        assertThat(testNumber, is(notNullValue(Integer.class)));
    }
    /**
     * instanceOf(Class<?>)
     * 如果检查的对象是指定类类型的实例，则 instanceOf(Class<?>) 匹配。
     * 为了验证，此方法在内部调用 Class 类的 isIntance(Object)
     */
    @Test
    void UsingInstanceOfForMatch(){
        assertThat("instanceOf example", is(instanceOf(String.class)));
        assertThat(new City(), is(instanceOf(Location.class)));

    }
    /**
     * isA （Class<T> 类型）
     * isA(Class<T> type) 是上述 instanceOf(Class<?>) 的快捷方式。它采用与 instanceOf(Class<?>) 完全相同类型的参数：
     */
    @Test
    void UsingIsAForMatch(){
        assertThat("isA match", isA(String.class));
        assertThat(new City(), isA(Location.class));
    }
    /**
     * sameInstance()
     * 如果两个引用变量指向堆中的同一个对象，则 sameInstance() 匹配：
     */
    @Test
    void UsingSameInstanceForMatch(){
        String string1 = "Viseron";
        String string2 = string1;
        String d = new String("Version");

        assertThat(string1, is(sameInstance(string2)));
        assertThat(string1, is(sameInstance(d)));

        //equalTo比较内容；sameInstance比较内存地址
        List<String> actualList = Arrays.asList("equalTo", "match");
        assertThat(actualList, is(equalTo(Arrays.asList("equalTo", "match"))));
        assertThat(actualList, is(sameInstance(Arrays.asList("equalTo", "match"))));
    }

    /**
     * any(Class<T>)
     * 检查类是否与实际对象的类型相同
     */
    @Test
    void UsingAnyForMatch(){
        assertThat("test string", is(any(String.class)));
        assertThat("test string", is(any(Object.class)));
        assertThat(new City(), is(any(Location.class)));
    }
    /**
     * allOf(Matcher<? extends T>…) and anyOf(Matcher<? extends T>…)
     * 我们可以使用 allOf(Matcher<? extends T>...) 来断言实际对象是否与所有指定条件匹配：
     * anyOf(Matcher<? extends T>…) 的行为类似于 allOf(Matcher<? extends T>…) ，但如果检查的对象匹配任何指定的条件，则匹配
     */
    @Test
    void UsingAllOfForMatch(){
        String testString = "abc";
        assertThat(testString,
                allOf(
                    //是否以a开头
                    startsWith("a"),
                    //是否以c结尾
                    endsWith("c"),
                    //是否包含bc
                    containsString("bc"),
                    //不区分大小写的是否以AB开头
                    startsWithIgnoringCase("AB"),
                    //不区分大小写的是否以BC结尾
                    endsWithIgnoringCase("BC"),
                    //对应正则匹配
                    matchesRegex("abc"),
                    //不区分大小写的内容匹配
                    equalToIgnoringCase("ABC"),
                    //对应字段长度是否为
                    hasLength(3)
                )
        );

//        String testString2 = "Hector killed Achilles";
//        assertThat(testString2, anyOf(startsWith("Hec"), containsString("baeldung")));
    }
    /**
     * hasItem(T) and hasItem(Matcher<? extends T>)
     * 如果检查的 Iterable 集合与 hasItem() 或 hasItem(Matcher<? extends T>) 中的给定对象或匹配器匹配，则这些匹配。
     * 同样，我们也可以使用hasItems(T…) 和hasItems(Matcher<? extends T>…) 对多个项目进行断言
     */
    @Test
    void UsingHasItemForMatch(){
        List<String> list = Arrays.asList("java", "hamcrest", "junit5");

        assertThat(list, hasItem("java"));
        assertThat(list, hasItem(isA(String.class)));

        assertThat(list, hasItems("java", "junit5"));
        assertThat(list, hasItems(isA(String.class), endsWith("est")));
    }
    /**
     * both(Matcher<? extends T>) and either(Matcher<? extends T>)
     * both(Matcher<? extends T>) 在两个指定条件都匹配检查对象时匹配：
     * 当任一指定条件与检查对象匹配时，either(Matcher<? extends T>) 匹配：
     *
     */
    @Test
    void UsingBothForMatch(){
        String testString = "daenerys targaryen";
        assertThat(testString, both(startsWith("daene")).and(containsString("yen")));
        assertThat(testString, either(startsWith("tar")).or(containsString("targaryen")));

    }
}
