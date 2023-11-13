package com.czarnecki.food.ordering.service.domain;

import com.czarnecki.food.ordering.service.domain.entity.Order;
import com.czarnecki.food.ordering.service.domain.entity.Restaurant;
import com.czarnecki.food.ordering.service.domain.event.OrderCancelledEvent;
import com.czarnecki.food.ordering.service.domain.event.OrderCreatedEvent;
import com.czarnecki.food.ordering.service.domain.event.OrderPaidEvent;

import java.util.List;

public interface OrderDomainService {
    OrderCreatedEvent validateAndInitiateOrder(Order order, Restaurant restaurant);

    OrderPaidEvent payOrder(Order order);

    void approveOrder(Order order);

    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages);

    void cancelOrder(Order order, List<String> failureMessages);
}
