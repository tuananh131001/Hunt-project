package com.s3864077.hunt.repository;

import com.s3864077.hunt.model.BillOfMaterial;
import com.s3864077.hunt.model.MaterialsPurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialsPurchaseOrderRepository extends JpaRepository<MaterialsPurchaseOrder, Long> {
}
