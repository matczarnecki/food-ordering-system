package com.czarnecki.food.ordering.service.domain.ports.output.repository;

import com.czarnecki.food.ordering.service.domain.entity.Order;
import com.czarnecki.food.ordering.service.domain.valueobject.TrackingId;

import java.util.Optional;

public interface OrderRepository {

    Order save(Order order);

    Optional<Order> findByTrackingId(TrackingId trackingId);
}
