package com.epam.training.microservices.taxiorderservice.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long chainId;
    private String username;
    private String driverUsername;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private String information;

    public Order(String information) {
        this.information = information;
    }

    public Order(Order order) {
        this.id = order.getId();
        this.chainId = order.getChainId();
        this.username = order.getUsername();
        this.driverUsername = order.getDriverUsername();
        this.status = order.getStatus();
        this.information = order.getInformation();
    }
}
