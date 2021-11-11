package com.epam.training.microservices.taxiorderservice.repository;

import com.epam.training.microservices.taxiorderservice.model.Order;
import com.epam.training.microservices.taxiorderservice.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> getOrderInformationByStatus(OrderStatus status);
}
