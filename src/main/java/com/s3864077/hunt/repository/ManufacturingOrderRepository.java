package com.s3864077.hunt.repository;

import com.s3864077.hunt.model.ManufacturingOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface ManufacturingOrderRepository extends JpaRepository<ManufacturingOrder, Long> {

    Page<ManufacturingOrder> findByClientNameContainingIgnoreCase(String clientName, Pageable pageable);

//    Page<ManufacturingOrder> findByExpectedCompletionDate(Date expectedCompletionDate, Pageable pageable);
}

