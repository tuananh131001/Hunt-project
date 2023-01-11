package com.s3864077.hunt.service.impl;

import com.s3864077.hunt.model.BillOfMaterial;
import com.s3864077.hunt.repository.BillOfMaterialRepository;
import com.s3864077.hunt.service.BillOfMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillOfMaterialServiceImpl implements BillOfMaterialService {

    private final BillOfMaterialRepository billOfMaterialRepository;

    @Autowired
    public BillOfMaterialServiceImpl(BillOfMaterialRepository billOfMaterialRepository) {
        this.billOfMaterialRepository = billOfMaterialRepository;
    }

    @Override
    public List<BillOfMaterial> getAllBillOfMaterials(Pageable pageable) {
        return billOfMaterialRepository.findAll(pageable).getContent();
    }

    @Override
    public Optional<BillOfMaterial> getBillOfMaterialById(Long id) {
        return billOfMaterialRepository.findById(id);
    }

    @Override
    public BillOfMaterial createBillOfMaterial(BillOfMaterial billOfMaterial) {
        return billOfMaterialRepository.save(billOfMaterial);
    }

    @Override
    public BillOfMaterial updateBillOfMaterial(BillOfMaterial billOfMaterial) {
        return billOfMaterialRepository.save(billOfMaterial);
    }

    @Override
    public void deleteBillOfMaterial(Long id) {
        billOfMaterialRepository.deleteById(id);
    }
}
