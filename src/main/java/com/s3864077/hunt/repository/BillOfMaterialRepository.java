package com.s3864077.hunt.repository;

import com.s3864077.hunt.model.BillOfMaterial;
import com.s3864077.hunt.model.ManufacturingOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillOfMaterialRepository extends JpaRepository<BillOfMaterial, Long> {
}
