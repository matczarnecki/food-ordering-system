package com.czarnecki.food.ordering.service.domain.ports.output.repository;

import com.czarnecki.food.ordering.service.domain.entity.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
    Optional<Customer> findCustomer(UUID customerId);
}
