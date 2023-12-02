package com.czarnecki.food.ordering.order.service.dataaccess.restaurant.adapter;

import com.czarnecki.food.ordering.order.service.dataaccess.restaurant.entity.RestaurantEntity;
import com.czarnecki.food.ordering.order.service.dataaccess.restaurant.mapper.RestaurantDataAccessMapper;
import com.czarnecki.food.ordering.order.service.dataaccess.restaurant.repository.RestaurantJpaRepository;
import com.czarnecki.food.ordering.service.domain.entity.Restaurant;
import com.czarnecki.food.ordering.service.domain.ports.output.repository.RestaurantRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RestaurantRepositoryImpl implements RestaurantRepository {
    private final RestaurantJpaRepository restaurantJpaRepository;
    private final RestaurantDataAccessMapper restaurantDataAccessMapper;

    public RestaurantRepositoryImpl(RestaurantJpaRepository restaurantJpaRepository, RestaurantDataAccessMapper restaurantDataAccessMapper) {
        this.restaurantJpaRepository = restaurantJpaRepository;
        this.restaurantDataAccessMapper = restaurantDataAccessMapper;
    }

    @Override
    public Optional<Restaurant> findRestaurantInformation(Restaurant restaurant) {
        List<UUID> restaurantProducts = restaurantDataAccessMapper.restaurantToRestaurantProducts(restaurant);
        Optional<List<RestaurantEntity>> restaurantEntities = restaurantJpaRepository
                .findByRestaurantIdAndProductIdIn(restaurant.getId().getValue(), restaurantProducts);
        return restaurantEntities.map(restaurantDataAccessMapper::restaurantEntityToRestaurant);
    }
}
