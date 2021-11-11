package com.epam.training.microservices.taxiorderservice.service;

import com.epam.training.microservices.taxiorderservice.model.Order;
import com.epam.training.microservices.taxiorderservice.model.OrderStatus;
import com.epam.training.microservices.taxiorderservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public List<Order> getUnassignedOrders() {
        return orderRepository.getOrderInformationByStatus(OrderStatus.CREATED);
    }

    @Override
    public Order createOrder(Order orderInformation) {
        return orderRepository.save(orderInformation);
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        return orderRepository.save(order);
    }
}
