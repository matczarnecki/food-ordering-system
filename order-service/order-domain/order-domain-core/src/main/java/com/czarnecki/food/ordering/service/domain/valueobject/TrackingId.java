package com.czarnecki.food.ordering.service.domain.valueobject;

import com.czarnecki.food.ordering.domain.valueobject.BaseId;

import java.util.UUID;

public class TrackingId extends BaseId<UUID> {
    public TrackingId(UUID value) {
        super(value);
    }
}
