package com.testeru.yaml;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.testeru.entity.OrderLines;
import com.testeru.entity.OrderLists;
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
 * @description: 02、单个map+list解析
 * @Version 1.0
 * @create: 2022/1/4 4:40 下午
 */
public class YamlMapListUnitTest {
    @Test
    void mapListMapTest() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        TypeReference<HashMap<String,List<HashMap<String, Object>>>> typeReference =
                new TypeReference<HashMap<String,List<HashMap<String, Object>>>>() {};
        HashMap<String,List<HashMap<String, Object>>> hashMaps = mapper.readValue(
                new File("src/test/resources/yaml/orderlines.yaml"), typeReference);
        System.out.println(hashMaps);
        hashMaps.get("orderLines").forEach(hashMap -> {
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
    public void orderLinesTest() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        //功能上等价的便捷方法： mapper.registerModules(mapper.findModules());
        //我们需要使用 findAndRegisterModules方法，以便 Jackson正确处理我们的日期
        //Jackson也可以自动搜索所有模块，不需要我们手动注册
        mapper.findAndRegisterModules();
        TypeReference<OrderLines> typeReference = new TypeReference<OrderLines>() {
        };
        OrderLines orderLines = mapper.readValue(new File("src/test/resources/yaml/orderlines.yaml"), typeReference);
        System.out.println(orderLines);
        orderLines.getOrderLines().forEach(orderLine -> {
            assertAll(
                    () -> assertThat(orderLine.getItem(), startsWith("No")),
                    () -> assertThat(orderLine.getQuantity(), is(greaterThan(9))),
                    () -> assertThat(orderLine.getUnitPrice(), is(closeTo(new BigDecimal(1.0),new BigDecimal(4.00))))
            );
        });
    }
    @Test
    public void orderListsTest() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        //功能上等价的便捷方法： mapper.registerModules(mapper.findModules());
        //我们需要使用 findAndRegisterModules方法，以便 Jackson正确处理我们的日期
        //Jackson也可以自动搜索所有模块，不需要我们手动注册
        mapper.findAndRegisterModules();
        TypeReference<OrderLists> typeReference = new TypeReference<OrderLists>() {
        };
        OrderLists orderLists = mapper.readValue(new File("src/test/resources/yaml/orderlines.yaml"), typeReference);
        System.out.println(orderLists);
        orderLists.getLists().forEach(orderList -> {
            assertAll(
                    () -> assertThat(orderList.getOtherItem(), startsWith("No")),
                    () -> assertThat(orderList.getQua(), is(greaterThan(9))),
                    () -> assertThat(orderList.getPrice(), is(closeTo(new BigDecimal(1.0),new BigDecimal(4.00))))
            );
        });
    }
}
