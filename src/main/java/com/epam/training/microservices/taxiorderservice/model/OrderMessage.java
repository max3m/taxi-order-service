package com.epam.training.microservices.taxiorderservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class OrderMessage {
    private Long id;
    private Long chainId;
    private String username;
    private String driverUsername;
    private OrderStatus status;
    private String information;
    private LocalDateTime localDateTime;

    public OrderMessage(Order order) {
        this.id = order.getId();
        this.chainId = order.getChainId();
        this.username = order.getUsername();
        this.driverUsername = order.getDriverUsername();
        this.status = order.getStatus();
        this.information = order.getInformation();
        this.localDateTime = LocalDateTime.now();
    }
}
