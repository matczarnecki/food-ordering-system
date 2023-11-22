package com.czarnecki.food.ordering.service.domain.ports.output.message.publisher.payment;

import com.czarnecki.food.ordering.domain.event.publisher.DomainEventPublisher;
import com.czarnecki.food.ordering.service.domain.event.OrderCancelledEvent;

public interface OrderCancelledPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCancelledEvent> {
}
