package com.activedge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class StockResponse {
    private String name;
    private BigDecimal amount;
}
