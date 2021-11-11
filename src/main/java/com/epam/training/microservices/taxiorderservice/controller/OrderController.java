package com.epam.training.microservices.taxiorderservice.controller;

import com.epam.training.microservices.taxiorderservice.model.Order;
import com.epam.training.microservices.taxiorderservice.model.OrderMessage;
import com.epam.training.microservices.taxiorderservice.service.OrderService;
import com.epam.training.microservices.taxiorderservice.service.ProducerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class OrderController {
    private final OrderService orderService;
    private final ProducerService producerService;

    @GetMapping("/orders")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getUnassignedOrders(){
        return orderService.getUnassignedOrders();
    }

    @PostMapping("/orders")
    @ResponseStatus(HttpStatus.CREATED)
    public Order sendOrderCreationRequest(@RequestBody Order order) {
        Order processedOrder = orderService.createOrder(order);
        producerService.produce(new OrderMessage(processedOrder));
        return processedOrder;
    }

    @PutMapping("/orders/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Order sendOrderUpdateRequest(@PathVariable("id") Long id, @RequestBody Order order) {
        Order processedOrder = orderService.createOrder(order);
        producerService.produce(new OrderMessage(processedOrder));
        return orderService.updateOrder(id, processedOrder);
    }


}
