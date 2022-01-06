package com.testeru.buy;

import com.testeru.base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description:
 * @Version 1.0
 * @create: 2021/12/27 2:54 下午
 */
@Tag("buy")
@DisplayName("零食相关测试用例")
public class EatsTest extends BaseTest {

    @Test
    @Tag("search")
    @Tag("eats")
    @DisplayName("搜索零食")
    void searchEats(){
        get();

    }
}
