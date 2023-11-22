package com.czarnecki.food.ordering.domain.event.publisher;

import com.czarnecki.food.ordering.domain.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {

    void publish(T domainEvent);
}
