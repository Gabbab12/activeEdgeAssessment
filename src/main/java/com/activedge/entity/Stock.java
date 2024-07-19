package com.activedge.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table("stocks")
public class Stock extends BaseEntity {
    @Id
    private Long id;

    @Column("stock_name")
    private String name;

    @Column("stock_amount")
    private BigDecimal amount;
}
