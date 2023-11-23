package com.czarnecki.food.ordering.service.domain.mapper;

import com.czarnecki.food.ordering.domain.valueobject.CustomerId;
import com.czarnecki.food.ordering.domain.valueobject.Money;
import com.czarnecki.food.ordering.domain.valueobject.ProductId;
import com.czarnecki.food.ordering.domain.valueobject.RestaurantId;
import com.czarnecki.food.ordering.service.domain.dto.create.CreateOrderCommand;
import com.czarnecki.food.ordering.service.domain.dto.create.CreateOrderResponse;
import com.czarnecki.food.ordering.service.domain.dto.create.OrderAddress;
import com.czarnecki.food.ordering.service.domain.dto.track.TrackOrderResponse;
import com.czarnecki.food.ordering.service.domain.entity.Order;
import com.czarnecki.food.ordering.service.domain.entity.OrderItem;
import com.czarnecki.food.ordering.service.domain.entity.Product;
import com.czarnecki.food.ordering.service.domain.entity.Restaurant;
import com.czarnecki.food.ordering.service.domain.valueobject.StreetAddress;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderDataMapper {

    public Restaurant createOrderCommandToRestaurant(CreateOrderCommand createOrderCommand) {
        return Restaurant.builder()
                .restaurantId(new RestaurantId(createOrderCommand.getRestaurantId()))
                .products(createOrderCommand.getItems()
                        .stream()
                        .map((orderItem -> new Product(new ProductId(orderItem.getProductId()))))
                        .collect(Collectors.toList()))
                .build();
    }

    public Order createOrderCommandToOrder(CreateOrderCommand createOrderCommand) {
        return Order.builder()
                .customerId(new CustomerId(createOrderCommand.getCustomerId()))
                .restaurantId(new RestaurantId(createOrderCommand.getRestaurantId()))
                .deliveryAddress(orderAddressToStreetAddress(createOrderCommand.getAddress()))
                .price(new Money(createOrderCommand.getPrice()))
                .items(orderItemsToOrderItemEntities(createOrderCommand.getItems()))
                .build();
    }

    public CreateOrderResponse orderToCreateOrderResponse(Order order, String message) {
        return CreateOrderResponse.builder()
                .orderTrackingId(order.getTrackingId().getValue())
                .orderStatus(order.getOrderStatus())
                .message(message)
                .build();
    }

    public TrackOrderResponse orderToTrackOrderResponse(Order order) {
        return TrackOrderResponse.builder()
                .orderTrackingId(order.getTrackingId().getValue())
                .orderStatus(order.getOrderStatus())
                .failureMessages(order.getFailureMessages())
                .build();
    }

    private List<OrderItem> orderItemsToOrderItemEntities(List<com.czarnecki.food.ordering.service.domain.dto.create.OrderItem> orderItems) {
        return orderItems.stream()
                .map(orderItem -> OrderItem.builder()
                        .product(new Product(new ProductId(orderItem.getProductId())))
                        .price(new Money(orderItem.getPrice()))
                        .quantity(orderItem.getQuantity())
                        .subTotal(new Money(orderItem.getSubTotal()))
                        .build())
                .collect(Collectors.toList());
    }

    private StreetAddress orderAddressToStreetAddress(OrderAddress orderAddress) {
        return new StreetAddress(UUID.randomUUID(),
                orderAddress.getStreet(),
                orderAddress.getPostalCode(),
                orderAddress.getCity());
    }
}
