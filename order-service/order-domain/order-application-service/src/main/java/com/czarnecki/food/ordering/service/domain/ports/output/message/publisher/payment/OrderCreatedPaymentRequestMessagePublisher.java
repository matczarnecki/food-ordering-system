package com.czarnecki.food.ordering.service.domain.ports.output.message.publisher.payment;

import com.czarnecki.food.ordering.domain.event.publisher.DomainEventPublisher;
import com.czarnecki.food.ordering.service.domain.event.OrderCreatedEvent;

public interface OrderCreatedPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCreatedEvent> {
}
