package com.testeru.suitecases;

import org.junit.platform.suite.api.*;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description: 09、过滤出不包含tag标签的类和方法去执行
 * @Version 1.0
 * @create: 2021/12/27 3:11 下午
 */

@SuiteDisplayName("所有tag用例都执行")
@Suite
@SelectPackages({
       "com.testeru.buy"
})
@ExcludeTags({
        "buy"
})
public class ExcludeTagTest {
}
