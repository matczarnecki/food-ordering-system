package com.czarnecki.food.ordering.service.domain.entity;

import com.czarnecki.food.ordering.domain.entity.AggregateRoot;
import com.czarnecki.food.ordering.domain.valueobject.CustomerId;

public class Customer extends AggregateRoot<CustomerId> {

    public Customer() {
    }

    public Customer(CustomerId customerId) {
        super.setId(customerId);
    }
}
