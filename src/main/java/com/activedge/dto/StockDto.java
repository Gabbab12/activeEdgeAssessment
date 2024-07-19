package com.activedge.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StockDto {
    private String name;
    private BigDecimal amount;
}
