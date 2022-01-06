package com.testeru.entity;


import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Order {
    private String orderNo;
    private LocalDate date;
    private String customerName;
    private List<OrderLine> orderLines;


    public Order() {
    }

    public Order(String orderNo, LocalDate date, String customerName, List<OrderLine> orderLines) {
        this.orderNo = orderNo;
        this.date = date;
        this.customerName = customerName;
        this.orderLines = orderLines;
    }
}
