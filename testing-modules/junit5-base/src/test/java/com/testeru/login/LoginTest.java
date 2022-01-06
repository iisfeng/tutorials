package com.testeru.login;

import com.testeru.base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description: 登录相关测试
 * @Version 1.0
 * @create: 2021/12/27 2:54 下午
 */
@DisplayName("登录相关用例")
public class LoginTest extends BaseTest {

    //手机号登录
    @Test
    @DisplayName("手机号登录")
    @Tag("iphone")
    @Tag("app")//app端登录
    void iphoneLoginTest(){
        get();
    }
}
