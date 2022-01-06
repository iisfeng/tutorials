package com.testeru.suitecases;

import com.testeru.login.LoginTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description: 01、过滤出需要执行的单个测试类
 * @Version 1.0
 * @create: 2021/12/27 3:06 下午
 */
//自定义显示名称
@SuiteDisplayName("单个登录类用例")
@Suite
@SelectClasses(LoginTest.class)
public class SelectClasseTest {
}
