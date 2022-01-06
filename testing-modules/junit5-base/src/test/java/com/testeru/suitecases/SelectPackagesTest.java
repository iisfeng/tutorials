package com.testeru.suitecases;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description: 03、执行测试包下的所有类
 * @Version 1.0
 * @create: 2021/12/30 3:42 下午
 */
@Suite
//参数可以String 也可以集合{}
@SelectPackages({
        //执行该包下的所有测试类
        "com.testeru.buy"
})
public class SelectPackagesTest {
}
