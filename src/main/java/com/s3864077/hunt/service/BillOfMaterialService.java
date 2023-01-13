package com.s3864077.hunt.service;

import com.s3864077.hunt.model.BillOfMaterial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BillOfMaterialService {
    Page<BillOfMaterial> getAllBillOfMaterials(Pageable pageable);

    Optional<BillOfMaterial> getBillOfMaterialById(Long id);

    BillOfMaterial createBillOfMaterial(BillOfMaterial billOfMaterial);

    BillOfMaterial updateBillOfMaterial(BillOfMaterial billOfMaterial);

    void deleteBillOfMaterial(Long id);
}
