package com.epam.training.microservices.taxiorderservice.service;

import com.epam.training.microservices.taxiorderservice.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getUnassignedOrders();
    Order createOrder(Order orderInformation);
    Order updateOrder(Long id, Order orderInformation);
}
