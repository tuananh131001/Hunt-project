package com.s3864077.hunt.service;

import com.s3864077.hunt.model.ManufacturingOrder;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ManufacturingOrderService {
    List<ManufacturingOrder> getAllManufacturingOrders(Pageable pageable);

    Optional<ManufacturingOrder> getManufacturingOrderById(Long id);

    ManufacturingOrder createManufacturingOrder(ManufacturingOrder manufacturingOrder);

    ManufacturingOrder updateManufacturingOrder(ManufacturingOrder manufacturingOrder);

    void deleteManufacturingOrder(Long id);
}
