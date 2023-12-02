package com.czarnecki.food.ordering.order.service.dataaccess.customer.mapper;

import com.czarnecki.food.ordering.domain.valueobject.CustomerId;
import com.czarnecki.food.ordering.order.service.dataaccess.customer.entity.CustomerEntity;
import com.czarnecki.food.ordering.service.domain.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataAccessMapper {

    public Customer customerEntityToCustomer(CustomerEntity customerEntity) {
        return new Customer(new CustomerId(customerEntity.getId()));
    }

    public CustomerEntity customerToCustomerEntity(Customer customer) {
        return CustomerEntity.builder()
                .id(customer.getId().getValue())
                .build();
    }

}
