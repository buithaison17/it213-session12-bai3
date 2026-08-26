package com.example.bai2.model.dto;

import com.example.bai2.constants.ShipmentStatus;

public record ShipmentDto(
        String trackingCode,
        String customerFullName,
        String customerAddress,
        String shipperName,
        String currentLocation,
        ShipmentStatus status
) {
}
