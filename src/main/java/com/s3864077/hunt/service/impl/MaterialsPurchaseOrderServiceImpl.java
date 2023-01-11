package com.s3864077.hunt.service.impl;

import com.s3864077.hunt.model.MaterialsPurchaseOrder;
import com.s3864077.hunt.repository.MaterialsPurchaseOrderRepository;
import com.s3864077.hunt.service.MaterialsPurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialsPurchaseOrderServiceImpl implements MaterialsPurchaseOrderService {

    private final MaterialsPurchaseOrderRepository materialsPurchaseOrderRepository;

    @Autowired
    public MaterialsPurchaseOrderServiceImpl(MaterialsPurchaseOrderRepository materialsPurchaseOrderRepository) {
        this.materialsPurchaseOrderRepository = materialsPurchaseOrderRepository;
    }

    @Override
    public List<MaterialsPurchaseOrder> getAllMaterialsPurchaseOrders(Pageable pageable) {
        return materialsPurchaseOrderRepository.findAll(pageable).getContent();
    }

    @Override
    public Optional<MaterialsPurchaseOrder> getMaterialsPurchaseOrderById(Long id) {
        return materialsPurchaseOrderRepository.findById(id);
    }

    @Override
    public MaterialsPurchaseOrder createMaterialsPurchaseOrder(MaterialsPurchaseOrder materialsPurchaseOrder) {
        return materialsPurchaseOrderRepository.save(materialsPurchaseOrder);
    }

    @Override
    public MaterialsPurchaseOrder updateMaterialsPurchaseOrder(MaterialsPurchaseOrder materialsPurchaseOrder) {
        return materialsPurchaseOrderRepository.save(materialsPurchaseOrder);
    }

    @Override
    public void deleteMaterialsPurchaseOrder(Long id) {
        materialsPurchaseOrderRepository.deleteById(id);
    }
}
