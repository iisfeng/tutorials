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
@DisplayName("游戏相关测试用例")
public class GameTest extends BaseTest {

    @Test
    @Tag("search")
    @Tag("game")
    @DisplayName("搜索游戏")
    void searchGame(){
        get();

    }
}
