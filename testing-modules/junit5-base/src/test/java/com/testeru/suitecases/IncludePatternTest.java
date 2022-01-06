package com.testeru.suitecases;

import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description: 06、执行select包下 && 正则匹配的类
 * @Version 1.0
 * @create: 2021/12/27 3:11 下午
 */

@SuiteDisplayName("所有用例都执行")
@Suite
@SelectPackages({
       "com.testeru.buy"
})
@IncludeClassNamePatterns({
       "com.testeru.buy.*sTest"
})
public class IncludePatternTest {
}
