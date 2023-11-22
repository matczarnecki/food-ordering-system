package com.czarnecki.food.ordering.service.domain.ports.output.repository;

import com.czarnecki.food.ordering.service.domain.entity.Restaurant;

import java.util.Optional;

public interface RestaurantRepository {

    Optional<Restaurant> findRestaurantInformation(Restaurant restaurant);
}
