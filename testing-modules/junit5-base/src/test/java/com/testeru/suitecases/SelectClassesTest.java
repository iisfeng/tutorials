package com.testeru.suitecases;

import com.testeru.login.LoginTest;
import com.testeru.login.RegisterTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description: 02、过滤出需要执行的多个测试类
 * @Version 1.0
 * @create: 2021/12/27 3:11 下午
 */
@SuiteDisplayName("手机号登录注册用例")
@Suite
@SelectClasses({
        LoginTest.class,
        RegisterTest.class
})
public class SelectClassesTest {
}
