package com.example.bai2.model.entity;

import com.example.bai2.constants.ShipmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "shipments")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String trackingCode;
    private String customerFullName;
    private String customerPhone;
    private String customerAddress;
    @Column(precision = 10, scale = 2)
    private BigDecimal customerWalletBalance;
    private String shipperName;
    private String currentLocation;
    @Enumerated(EnumType.STRING)
    private ShipmentStatus status;
    private LocalDate estimatedDeliveryDate;
}
