package com.testeru.entity;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class OrderLine{
    private String item;
    private int quantity;
    private BigDecimal unitPrice;
    private LocalDate orderDate;

    public OrderLine() {
    }

    public OrderLine(String item, int quantity, BigDecimal unitPrice, LocalDate orderDate) {
        this.item = item;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.orderDate = orderDate;
    }
}
