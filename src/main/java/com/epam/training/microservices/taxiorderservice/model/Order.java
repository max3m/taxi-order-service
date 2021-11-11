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
    private String username;
    private String driverUsername;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private String information;

    public Order(String information) {
        this.information = information;
    }

    public Order(Order orderInformation) {
        this.id = orderInformation.getId();
        this.username = orderInformation.getUsername();
        this.driverUsername = orderInformation.getDriverUsername();
        this.status = orderInformation.getStatus();
        this.information = orderInformation.getInformation();
    }
}
