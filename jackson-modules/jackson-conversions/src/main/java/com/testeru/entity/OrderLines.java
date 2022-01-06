package com.testeru.entity;

import lombok.Data;

import java.util.List;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description:
 * @Version 1.0
 * @create: 2022/1/4 4:45 下午
 */
@Data
public class OrderLines {
    private List<OrderLine> orderLines;
}
