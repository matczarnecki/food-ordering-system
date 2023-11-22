package com.czarnecki.food.ordering.service.domain.ports.output.message.publisher.restaurantapproval;

import com.czarnecki.food.ordering.domain.event.publisher.DomainEventPublisher;
import com.czarnecki.food.ordering.service.domain.event.OrderPaidEvent;

public interface OrderPaidRestaurantRequestMessagePublisher extends DomainEventPublisher<OrderPaidEvent> {
}
