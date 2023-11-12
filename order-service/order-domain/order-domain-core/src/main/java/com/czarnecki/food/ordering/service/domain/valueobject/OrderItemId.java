package com.czarnecki.food.ordering.service.domain.valueobject;

import com.czarnecki.food.ordering.domain.valueobject.BaseId;


public class OrderItemId extends BaseId<Long> {
    public OrderItemId(Long value) {
        super(value);
    }
}
