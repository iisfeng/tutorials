package com.testeru.yaml;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.testeru.entity.OrderLine;
import com.testeru.entity.OrderList;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description: 01、对应list数据类型解析
 * @Version 1.0
 * @create: 2022/1/4 11:32 上午
 */
public class YamlListUnitTest {
    @Test
    void listMapTest() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        TypeReference<List<HashMap<String, Object>>> typeReference =
                new TypeReference<List<HashMap<String, Object>>>() {};
        List<HashMap<String, Object>> hashMaps = mapper.readValue(
                new File("src/test/resources/yaml/orderlist.yaml"), typeReference);
        System.out.println(hashMaps);
        hashMaps.forEach(hashMap -> {
            assertAll(
                    () -> assertThat(hashMap.get("item").toString(), startsWith("No")),
                    () -> assertThat(Integer.parseInt(hashMap.get("quantity").toString()),
                            is(greaterThan(9))),
                    () -> assertThat(new BigDecimal(hashMap.get("unitPrice").toString()),
                            is(closeTo(new BigDecimal(1.0),new BigDecimal(4.00))))
            );
        });
    }

    @Test
    public void orderListTest() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        //功能上等价的便捷方法： mapper.registerModules(mapper.findModules());
        //我们需要使用 findAndRegisterModules方法，以便 Jackson正确处理我们的日期
        //Jackson也可以自动搜索所有模块，不需要我们手动注册
        mapper.findAndRegisterModules();
        TypeReference<List<OrderList>> typeReference = new TypeReference<List<OrderList>>() {
        };
        List<OrderList> orderLists = mapper.readValue(new File("src/test/resources/yaml/orderlist.yaml"), typeReference);
        System.out.println(orderLists);
        orderLists.forEach(orderList -> {
            assertAll(
                    () -> assertThat(orderList.getOtherItem(), startsWith("No")),
                    () -> assertThat(orderList.getQua(), is(greaterThan(9))),
                    () -> assertThat(orderList.getPrice(), is(closeTo(new BigDecimal(1.0),new BigDecimal(4.00))))
            );
        });
    }
    @Test
    public void orderLineTest() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        //功能上等价的便捷方法： mapper.registerModules(mapper.findModules());
        //我们需要使用 findAndRegisterModules方法，以便 Jackson正确处理我们的日期
        //Jackson也可以自动搜索所有模块，不需要我们手动注册
        mapper.findAndRegisterModules();
        TypeReference<List<OrderLine>> typeReference = new TypeReference<List<OrderLine>>() {
        };
        List<OrderLine> orderLines = mapper.readValue(new File("src/test/resources/yaml/orderlist.yaml"), typeReference);
        System.out.println(orderLines);
        orderLines.forEach(orderLine -> {
            assertAll(
                    () -> assertThat(orderLine.getItem(), startsWith("No")),
                    () -> assertThat(orderLine.getQuantity(), is(greaterThan(9))),
                    () -> assertThat(orderLine.getUnitPrice(), is(closeTo(new BigDecimal(1.0),new BigDecimal(4.00))))
            );
        });
    }
}
