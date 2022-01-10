package com.testeru.entity;

import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


/**
 * @program: tutorials
 * @author: 盖盖
 * @description:
 * @Version 1.0
 * @create: 2022/1/7 1:39 下午
 */
@Data
public class DemoData {
    private String string;
    //这里用string 去接日期再进行格式化
    @DateTimeFormat("yyyy/MM/dd HH:mm")
    private String date;
    private Double doubleData;
}

