package com.testeru.login;

import com.testeru.base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description:
 * @Version 1.0
 * @create: 2021/12/27 3:03 下午
 */
@DisplayName("注册相关用例")
public class RegisterTest extends BaseTest {

    @Test
    @Tag("Register")
    @DisplayName("手机号注册用户")
    void iPhoneRegister(){
        get();
    }
}
