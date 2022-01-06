package com.testeru.hcrscases.object;



import com.testeru.hcrscases.entity.City;
import com.testeru.hcrscases.entity.Location;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestObjectUnitTest {

    /**
     * hasToString
     * hasToString方法验证某个对象是否具有返回特定String的toString方法
     * 创建一个City并验证其toString方法是否返回我们想要的字符串
     */
    @Test
    public void givenACity_whenHasToString_thenCorrect() {
        City city = new City("BeiJing", "capital");

        assertThat(city, hasToString("[Name: BeiJing, State: capital]"));
    }

    /**
     * 不是检查相等性，而是检查其他一些条件
     * hasToString
     * hasToString被重载并且可以接收字符串或文本匹配器作为参数
     *
     */
    @Test
    public void givenACity_whenHasToStringEqualToIgnoringCase_thenCorrect() {
        City city = new City("BeiJing", "capital");

        assertThat(city, hasToString(equalToIgnoringCase("[NAME: BEIJING, STATE: CAPITAL]")));
    }

    /**
     *  创建一个字符串匹配器，当检查的字符串为空或长度为零时匹配。例如：
     *  assertThat(((String)null), is(emptyOrNullString()))
     */
    @Test
    public void givenACity_whenHasToStringEmptyOrNullString_thenCorrect() {
        City city = new City(null, null);

        assertThat(city, hasToString(emptyOrNullString()));
    }

    /**
     * typeCompatibleWith
     * 创建一个 Class 匹配器，当指定的 baseType 可从检查的类中分配时，该匹配器匹配。例如：
     * assertThat(Integer.class, typeCompatibleWith(Number.class))
     * 参数：
     * baseType – 用于检查类的基类
     */
    @Test
    public void givenACity_whenTypeCompatibleWithLocation_thenCorrect() {
        City city = new City("BeiJing", "capital");

        assertThat(city.getClass(), is(typeCompatibleWith(Location.class)));
    }

    @Test
    public void givenACity_whenTypeNotCompatibleWithString_thenCorrect() {
        City city = new City("BeiJing", "capital");

        assertThat(city.getClass(), is(not(typeCompatibleWith(String.class))));
    }

    /**
     * 所有 Java 对象都应通过以下测试
     */
    @Test
    public void givenACity_whenTypeCompatibleWithObject_thenCorrect() {
        City city = new City("BeiJing", "capital");

        assertThat(city.getClass(), is(typeCompatibleWith(Object.class)));
    }

}
