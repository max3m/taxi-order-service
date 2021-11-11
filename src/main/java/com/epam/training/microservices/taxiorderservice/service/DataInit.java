package com.epam.training.microservices.taxiorderservice.service;

import com.epam.training.microservices.taxiorderservice.model.Order;
import com.epam.training.microservices.taxiorderservice.model.OrderMessage;
import com.epam.training.microservices.taxiorderservice.model.OrderStatus;
import com.epam.training.microservices.taxiorderservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataInit implements ApplicationRunner {
    private final OrderRepository orderRepository;
    private final ProducerService producerService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count = orderRepository.count();

        if(count == 0) {
            for (int i = 0; i < 10; i++) {
                Order order = new Order();
                order.setUsername("Customer" + i);
                order.setStatus(OrderStatus.CREATED);
                order.setInformation("Information" + i);
                orderRepository.save(order);
                producerService.produce(new OrderMessage(order));
            }
        }
    }
}
