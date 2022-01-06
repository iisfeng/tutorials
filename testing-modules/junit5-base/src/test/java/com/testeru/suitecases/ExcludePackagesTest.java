package com.testeru.suitecases;

import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description: 05、过滤不执行ExcludePackages包下的所有类
 * 注意⚠️：ExcludePackages参数必须在SelectPackages里面
 * @Version 1.0
 * @create: 2021/12/30 3:51 下午
 */
@Suite
@SelectPackages("com.testeru")
@ExcludePackages({
        "com.testeru.buy",
        "com.testeru.testcases"
})
public class ExcludePackagesTest {
}
