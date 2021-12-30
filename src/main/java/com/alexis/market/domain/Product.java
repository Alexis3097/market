package com.alexis.market.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class Product {
    private Long productId;
    private String name;
    private Long categoryId;
    private BigDecimal price;
    private int stock;
    private Boolean active;
    private Category category;
}
