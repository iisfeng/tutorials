package com.testeru.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: tutorials
 * @author: ηη
 * @description:
 * @Version 1.0
 * @create: 2022/1/4 5:30 δΈε
 */
@Data
public class OrderLists {
    @JsonProperty("orderLines")
    private List<OrderList> lists;
}
