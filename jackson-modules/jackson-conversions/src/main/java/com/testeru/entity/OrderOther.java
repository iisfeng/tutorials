package com.testeru.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderOther {
    @JsonProperty("orderNo")
    private String orderNum;
    @JsonProperty("date")
    private LocalDate Date;
    @JsonProperty("customerName")
    private String customername;
    @JsonProperty("orderLines")
    private List<OrderList> orderLists;
}
