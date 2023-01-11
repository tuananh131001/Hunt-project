package com.s3864077.hunt.service;

import com.s3864077.hunt.model.MaterialsPurchaseOrder;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MaterialsPurchaseOrderService {
    List<MaterialsPurchaseOrder> getAllMaterialsPurchaseOrders(Pageable pageable);

    Optional<MaterialsPurchaseOrder> getMaterialsPurchaseOrderById(Long id);

    MaterialsPurchaseOrder createMaterialsPurchaseOrder(MaterialsPurchaseOrder materialsPurchaseOrder);

    MaterialsPurchaseOrder updateMaterialsPurchaseOrder(MaterialsPurchaseOrder materialsPurchaseOrder);

    void deleteMaterialsPurchaseOrder(Long id);
}
