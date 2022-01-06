package com.testeru.hcrscases.custom;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description: 是否仅数字
 * @Version 1.0
 * @create: 2021/12/24 5:15 下午
 */
public class IsOnlyDigits extends TypeSafeMatcher<String> {
    @Override
    protected boolean matchesSafely(String item) {
        try {
            Integer.parseInt(item);
            return true;
        } catch (NumberFormatException nfe) {
            System.out.println(nfe.getMessage());
            return false;
        }
    }

    /**
     *  生成对象的描述。描述可能是对更大对象的描述的一部分，这只是一个组件，所以应该用适当的措辞
     * @param description
     */

    @Override
    public void describeTo(Description description) {
        description.appendText("测试Hamcrest");

    }


    public static Matcher<String> onlyDigits() {
        return new IsOnlyDigits();
    }
}
