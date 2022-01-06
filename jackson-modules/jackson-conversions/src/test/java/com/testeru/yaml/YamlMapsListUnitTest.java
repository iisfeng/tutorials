package com.testeru.yaml;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.testeru.entity.Order;
import com.testeru.entity.OrderOther;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description: 03、多个map+lists解析，无法用数据类型解析，只能实体类解析
 * @Version 1.0
 * @create: 2022/1/4 4:40 下午
 */
public class YamlMapsListUnitTest {

@Test
public void orderTest() throws IOException {
    ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    //功能上等价的便捷方法： mapper.registerModules(mapper.findModules());
    //我们需要使用 findAndRegisterModules方法，以便 Jackson正确处理我们的日期
    //Jackson也可以自动搜索所有模块，不需要我们手动注册
    mapper.findAndRegisterModules();
    TypeReference<Order> typeReference = new TypeReference<Order>() {
    };
    Order order = mapper.readValue(new File("src/test/resources/yaml/order.yaml"), typeReference);
    System.out.println(order);
    assertAll(
            () -> assertEquals("A001", order.getOrderNo()),
            () -> assertEquals(LocalDate.parse("2019-04-17", DateTimeFormatter.ISO_DATE), order.getDate()),
            () -> assertEquals("Customer, Joe", order.getCustomerName()),
            () -> assertEquals(2, order.getOrderLines().size())
    );
}
    @Test
    public void orderOtherTest() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        //功能上等价的便捷方法： mapper.registerModules(mapper.findModules());
        //我们需要使用 findAndRegisterModules方法，以便 Jackson正确处理我们的日期
        //Jackson也可以自动搜索所有模块，不需要我们手动注册
        mapper.findAndRegisterModules();
        TypeReference<OrderOther> typeReference = new TypeReference<OrderOther>() {
        };
        OrderOther orderOther = mapper.readValue(new File("src/test/resources/yaml/order.yaml"), typeReference);
        System.out.println(orderOther);
        orderOther.getOrderLists().forEach(orderList -> {
            assertAll(
                    () -> assertThat(orderList.getOtherItem(), startsWith("No")),
                    () -> assertThat(orderList.getQua(), is(greaterThan(9))),
                    () -> assertThat(orderList.getPrice(), is(closeTo(new BigDecimal(1.0),new BigDecimal(4.00))))
            );
        });
    }
}
