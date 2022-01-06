package com.testeru.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class OrderList {
    @JsonProperty("item")
    private String otherItem;
    @JsonProperty("quantity")
    private int qua;
    @JsonProperty("unitPrice")
    private BigDecimal price;
    @JsonProperty("orderDate")
//    @JsonFormat(pattern = "yyyy-MM-DD")
    private LocalDate date;
}
