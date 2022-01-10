package com.testeru.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.exception.ExcelCommonException;
import com.alibaba.excel.util.DateUtils;
import com.testeru.entity.ConverterReadData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.alibaba.fastjson.JSON;
/**
 * @program: tutorials
 * @author: 盖盖
 * @description:
 * @Version 1.0
 * @create: 2022/1/7 1:32 下午
 */
public class ConverterDataListener extends AnalysisEventListener<ConverterReadData> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConverterDataListener.class);
    private List<ConverterReadData> list = new ArrayList<>();

    @Override
    public void invoke(ConverterReadData data, AnalysisContext context) {
        list.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
//        assertEquals(list.size(), 1);
        ConverterReadData data = list.get(0);
//        try {
//            assertEquals(DateUtils.parseDate("2020-01-01 01:01:01"), data.getDate());
//        } catch (ParseException e) {
//            throw new ExcelCommonException("Test Exception", e);
//        }
//        assertEquals(DateUtils.parseLocalDateTime("2020-01-01 01:01:01", null, null), data.getLocalDateTime());
//        assertEquals(data.getBooleanData(), Boolean.TRUE);
//        assertEquals(data.getBigDecimal().doubleValue(), BigDecimal.ONE.doubleValue(), 0.0);
//        assertEquals(data.getBigInteger().intValue(), BigInteger.ONE.intValue(), 0.0);
//        assertEquals((long)data.getLongData(), 1L);
//        assertEquals((long)data.getIntegerData(), 1L);
//        assertEquals((long)data.getShortData(), 1L);
//        assertEquals((long)data.getByteData(), 1L);
//        assertEquals(data.getDoubleData(), 1.0, 0.0);
//        assertEquals(data.getFloatData(), (float)1.0, 0.0);
//        assertEquals(data.getString(), "测试");
//        assertEquals(data.getCellData().getStringValue(), "自定义");
        LOGGER.debug("First row:{}", JSON.toJSONString(list.get(0)));
    }
}