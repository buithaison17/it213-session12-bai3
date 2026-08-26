package com.example.bai2.tools;

import com.example.bai2.model.dto.ShipmentDto;
import com.example.bai2.model.entity.Shipment;
import com.example.bai2.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShipmentTrackingTool {
    private final ShipmentRepository shipmentRepository;

    @McpTool(
            description = "Lấy thông tin đơn hàng theo mã vận đơn"
    )
    public ShipmentDto getShipmentDetails(
            @McpToolParam(description = "Mã vận đơn, ví dụ: RK-88219")
            String trackingCode
    ) {
        Shipment shipment = shipmentRepository.findByTrackingCode(trackingCode)
                .orElseThrow(() -> new RuntimeException("Mã vận đơn không tồn tại"));

        return new ShipmentDto(
                shipment.getTrackingCode(),
                shipment.getCustomerFullName(),
                shipment.getCustomerAddress(),
                shipment.getShipperName(),
                shipment.getCurrentLocation(),
                shipment.getStatus()
        );
    }
}
