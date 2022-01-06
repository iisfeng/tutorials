
package com.testeru.csv;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.testeru.entity.OrderLine;
import com.testeru.entity.OrderList;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CsvUnitTest {
    CsvMapper csvMapper = new CsvMapper();

    /**
     * csv文件读取有header头的
     * 解析为实体类
     */
@Test
void csvReadWithHeader() throws IOException {
    //带着header读取
    CsvSchema orderLineSchema = CsvSchema.emptySchema().withHeader();
    //功能上等价的便捷方法： mapper.registerModules(mapper.findModules());
    //我们需要使用 findAndRegisterModules方法，以便 Jackson正确处理我们的日期
    //Jackson也可以自动搜索所有模块，不需要我们手动注册
    csvMapper.findAndRegisterModules();
    MappingIterator<OrderLine> orderLines = csvMapper.readerFor(OrderLine.class)
            .with(orderLineSchema)
            .readValues(new File("src/test/resources/csv/orderLines.csv"));
    System.out.println(orderLines.readAll());
}

    /**
     * csv文件读取有header头的
     * 解析为实体类
     */
@Test
void csvReadWithHeader1() throws IOException {
    //带着header读取
    CsvSchema orderLineSchema = CsvSchema.emptySchema().withHeader();
    //功能上等价的便捷方法： mapper.registerModules(mapper.findModules());
    //我们需要使用 findAndRegisterModules方法，以便 Jackson正确处理我们的日期
    //Jackson也可以自动搜索所有模块，不需要我们手动注册
    csvMapper.findAndRegisterModules();
    MappingIterator<OrderList> orderLines = csvMapper.readerFor(OrderList.class)
            .with(orderLineSchema)
            .readValues(new File("src/test/resources/csv/orderLines.csv"));
    System.out.println(orderLines.readAll());
}
    /**
     * csv读取没有header头的
     * 解析为实体类
     */
    @Test
    void csvReadOutHeader() throws IOException {

        //功能上等价的便捷方法： mapper.registerModules(mapper.findModules());
        //我们需要使用 findAndRegisterModules方法，以便 Jackson正确处理我们的日期
        //Jackson也可以自动搜索所有模块，不需要我们手动注册
        csvMapper.findAndRegisterModules();
        CsvSchema schema = CsvSchema.builder()
                .addColumn("item")
                .addColumn("quantity")
                .addColumn("unitPrice")
                .addColumn("orderDate")
                .build();
        MappingIterator<Object> objectMappingIterator = csvMapper.readerFor(OrderLine.class)
                .with(schema)
                .readValues(new File("src/test/resources/csv/orderlist.csv"));
        System.out.println(objectMappingIterator.readAll());
    }
    @Test
    void csvReadOutHeader1() throws IOException {

        //功能上等价的便捷方法： mapper.registerModules(mapper.findModules());
        //我们需要使用 findAndRegisterModules方法，以便 Jackson正确处理我们的日期
        //Jackson也可以自动搜索所有模块，不需要我们手动注册
        csvMapper.findAndRegisterModules();
        CsvSchema schema = CsvSchema.builder()
                .addColumn("item")
                .addColumn("quantity")
                .addColumn("unitPrice")
                .addColumn("orderDate")
                .build();
        MappingIterator<Object> objectMappingIterator = csvMapper.readerFor(OrderList.class)
                .with(schema)
                .readValues(new File("src/test/resources/csv/orderlist.csv"));
        System.out.println(objectMappingIterator.readAll());
    }
    /**
     * csv文件读取有header头的
     * 解析为map的
     * @throws IOException
     */
    @Test
    void csvReadWithHeaderMap() throws IOException {
        //功能上等价的便捷方法： mapper.registerModules(mapper.findModules());
        //我们需要使用 findAndRegisterModules方法，以便 Jackson正确处理我们的日期
        //Jackson也可以自动搜索所有模块，不需要我们手动注册
        csvMapper.findAndRegisterModules();
        //.setSkipFirstDataRow(true) 第一行header不解析
        CsvSchema schema = CsvSchema.builder().setSkipFirstDataRow(true)
                .addColumn("item")
                .addColumn("quantity")
                .addColumn("unitPrice")
                .addColumn("orderDate")
                .build();
        MappingIterator<Object> objectMappingIterator = csvMapper.readerForMapOf(String.class)
                // 注意：不需要包装
                .with(schema)
                .readValues(new File("src/test/resources/csv/orderLines.csv"));
        System.out.println(objectMappingIterator.readAll());
    }


    /**
     * csv读取没有header头的
     * 解析为实体类
     */
    @Test
    void csvReadOutHeaderMap() throws IOException {

        //功能上等价的便捷方法： mapper.registerModules(mapper.findModules());
        //我们需要使用 findAndRegisterModules方法，以便 Jackson正确处理我们的日期
        //Jackson也可以自动搜索所有模块，不需要我们手动注册
        csvMapper.findAndRegisterModules();
        CsvSchema schema = CsvSchema.builder()
                .addColumn("item")
                .addColumn("quantity")
                .addColumn("unitPrice")
                .addColumn("orderDate")
                .build();
        MappingIterator<Object> objectMappingIterator = csvMapper.readerForMapOf(String.class)
                .with(schema)
                .readValues(new File("src/test/resources/csv/orderlist.csv"));
        System.out.println(objectMappingIterator.readAll());
    }


    /**
     * csv文件转换为json文件
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    @Test
    public void givenCsvInput_thenWritesJson() throws JsonParseException, JsonMappingException, IOException {
        File jsonFromCsv = new File("src/test/resources/json/order.json");
        csvToJson(new File("src/test/resources/csv/orderLines.csv"), jsonFromCsv);


    }
    public static void csvToJson(File csvFile, File jsonFile) throws IOException {
        CsvSchema orderLineSchema = CsvSchema.emptySchema().withHeader();
        CsvMapper csvMapper = new CsvMapper();
        csvMapper.findAndRegisterModules();
        MappingIterator<OrderLine> orderLines = csvMapper.readerFor(OrderLine.class)
                .with(orderLineSchema)
                .readValues(csvFile);
        System.out.println(orderLines.readAll());

        new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT, true)
                .writeValue(jsonFile, orderLines.readAll());
    }
}
