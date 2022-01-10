package com.testeru.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson.JSON;
import com.testeru.entity.ConverterReadData;
import com.testeru.entity.DemoData;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static com.alibaba.excel.read.listener.PageReadListener.BATCH_COUNT;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description:
 * @Version 1.0
 * @create: 2022/1/7 11:55 上午
 */
public class ExcelUnitTest {
    List<DemoData> cachedDataList1 = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    @Test
    public void simpleRead() {
        String fileName = "src/test/resources/demo.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        // 这里每次会读取3000条数据 然后返回过来 直接调用使用数据就行
        EasyExcel.read(fileName, DemoData.class, new PageReadListener<DemoData>(dataList -> {
            cachedDataList1 = dataList;
        })).sheet().doRead();
        System.out.println(cachedDataList1);
    }

    @Test
    public void simpleRead1() {
        String fileName = "src/test/resources/demo.xlsx";

        EasyExcel.read(fileName, DemoData.class, new ReadListener<DemoData>() {
            //单次缓存的数据量
            public static final int BATCH_COUNT = 100;
            @Override
            public void invoke(DemoData data, AnalysisContext context) {
                cachedDataList1.add(data);
            }
            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
            }
        }).sheet().doRead();
        System.out.println(cachedDataList1);

        }
}
