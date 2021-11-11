package com.epam.training.microservices.taxiorderservice.service;

import com.epam.training.microservices.taxiorderservice.model.OrderMessage;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProducerService {
    private KafkaTemplate<String, OrderMessage> kafkaTemplate;

    public void produce(OrderMessage orderMessage) {
        kafkaTemplate.send("orderMessages", orderMessage);
    }
}
