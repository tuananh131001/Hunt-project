package com.s3864077.hunt.service.impl;

import com.s3864077.hunt.model.ManufacturingOrder;
import com.s3864077.hunt.repository.ManufacturingOrderRepository;
import com.s3864077.hunt.service.ManufacturingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturingOrderServiceImpl implements ManufacturingOrderService {

    private final ManufacturingOrderRepository manufacturingOrderRepository;

    @Autowired
    public ManufacturingOrderServiceImpl(ManufacturingOrderRepository manufacturingOrderRepository) {
        this.manufacturingOrderRepository = manufacturingOrderRepository;
    }

    @Override
    @Cacheable("MO")
    public List<ManufacturingOrder> getAllManufacturingOrders(Pageable pageable) {
        return manufacturingOrderRepository.findAll(pageable).getContent();
    }

    @Override
    @Cacheable("MO")
    public Optional<ManufacturingOrder> getManufacturingOrderById(Long id) {
        return manufacturingOrderRepository.findById(id);
    }

    @Override
    public ManufacturingOrder createManufacturingOrder(ManufacturingOrder manufacturingOrder) {
        return manufacturingOrderRepository.save(manufacturingOrder);
    }

    @Override
    public ManufacturingOrder updateManufacturingOrder(ManufacturingOrder manufacturingOrder) {
        return manufacturingOrderRepository.save(manufacturingOrder);
    }

    @Override
    public void deleteManufacturingOrder(Long id) {
        manufacturingOrderRepository.deleteById(id);
    }
}