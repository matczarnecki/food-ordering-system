package com.czarnecki.food.ordering.service.domain.entity;

import com.czarnecki.food.ordering.domain.entity.BaseEntity;
import com.czarnecki.food.ordering.domain.valueobject.Money;
import com.czarnecki.food.ordering.domain.valueobject.ProductId;

public class Product extends BaseEntity<ProductId> {
    private final String name;
    private final Money price;

    public Product(ProductId productId, String name, Money price) {
        super.setId(productId);
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }
}