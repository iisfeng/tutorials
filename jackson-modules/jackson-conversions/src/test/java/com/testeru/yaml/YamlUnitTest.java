package com.testeru.yaml;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.testeru.entity.Order;
import com.testeru.entity.OrderLine;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * @program: xunit
 * @author: 盖盖
 * @description:
 * @Version 1.0
 * @create: 2021/12/24 2:24 下午
 */
public class YamlUnitTest {
    private static ObjectMapper mapper;
    private static File orderOutput;

    @BeforeAll
    public static void setup() {
        //默认情况下，我们的文件将以三个破折号开头。这对 YAML 格式完全有效，但我们可以通过禁用YAMLFactory上的功能来关闭它
        mapper = new ObjectMapper(
                //不允许，禁用
                new YAMLFactory().disable(
                        //yaml文档显式开始标记（“---”）
                        YAMLGenerator.Feature.WRITE_DOC_START_MARKER
                )
        );
        //功能上等价的便捷方法： mapper.registerModules(mapper.findModules());
        //与 findModules() 一样，模块没有缓存，因此需要注意创建和共享单个映射器实例；或缓存内省的模块集。
        //我们需要使用 findAndRegisterModules方法，以便 Jackson正确处理我们的日期：
        //Jackson也可以自动搜索所有模块，不需要我们手动注册
        mapper.findAndRegisterModules();
        //Jackson将我们的日期写为字符串而不是单个数字部分。
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        orderOutput = new File("src/test/resources/yaml/orderOutput.yaml");
    }

    @AfterAll
    public static void cleanup() {
        orderOutput.deleteOnExit();
    }
    @Test
    public void test1() throws IOException {
        TypeReference<List<HashMap<String, Object>>> typeReference = new TypeReference<List<HashMap<String, Object>>>() {
        };
        List<HashMap<String, Object>> hashMaps = mapper.readValue(new File("src/test/resources/yaml/orderlist.yaml"), typeReference);

        hashMaps.forEach(hashMap -> {
            System.out.println(hashMap);
            assertAll(
                    () -> assertThat(hashMap.get("item").toString(), startsWith("No")),
                    () -> assertThat(Integer.parseInt(hashMap.get("quantity").toString()), is(greaterThan(9))),
                    () -> assertThat(new BigDecimal(hashMap.get("unitPrice").toString()), is(closeTo(new BigDecimal(1.0),new BigDecimal(4.00))))
            );
        });
    }


    @Test
    public void givenYamlObject_FileWritten() throws JsonGenerationException, JsonMappingException, IOException {

        //getAbsolutePath()返回此抽象路径名的绝对路径名字符串
        System.out.println(orderOutput.getAbsolutePath());
//        File outputYaml = new File(orderOutput.getAbsolutePath());
        List<OrderLine> lines = new ArrayList<>();
        lines.add(new OrderLine("Copper Wire (200ft)", 1, new BigDecimal(50.67).setScale(2, RoundingMode.HALF_UP),LocalDate.parse("2022-01-18", DateTimeFormatter.ISO_DATE)));
        lines.add(new OrderLine("Washers (1/4\")", 24, new BigDecimal(.15).setScale(2, RoundingMode.HALF_UP),LocalDate.parse("2022-04-18", DateTimeFormatter.ISO_DATE)));
        Order order = new Order(
                "B-9910",
                LocalDate.parse("2019-04-18", DateTimeFormatter.ISO_DATE),
                "Customer, Jane",
                lines);
        mapper.writeValue(orderOutput, order);

//        assertTrue(outputYaml.exists());
    }
}
