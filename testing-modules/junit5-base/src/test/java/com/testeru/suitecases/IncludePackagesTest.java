package com.testeru.suitecases;

import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description: 04、过滤执行IncludePackages包下的所有类
 * 注意⚠️：IncludePackages参数必须在SelectPackages里面
 * @Version 1.0
 * @create: 2021/12/30 3:51 下午
 */
@Suite
@SelectPackages("com.testeru")
@IncludePackages({
        "com.testeru.buy"
})
public class IncludePackagesTest {
}
