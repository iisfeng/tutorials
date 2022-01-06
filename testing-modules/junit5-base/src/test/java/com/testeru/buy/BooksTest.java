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
@DisplayName("图书相关测试用例")
public class BooksTest extends BaseTest {

    @Test
    @Tag("search")
    @Tag("book")
    @DisplayName("搜索图书")
    void searchBook(){
        get();

    }
    @Test
    @Tag("buy")
    @Tag("book")
    @DisplayName("购买图书")
    void buyBook(){
        get();

    }
}
