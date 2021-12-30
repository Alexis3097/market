package com.alexis.market.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Category {
    private Long categoryId;
    private String category;
    private Boolean active;
}
