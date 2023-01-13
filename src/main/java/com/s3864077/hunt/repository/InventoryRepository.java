package com.s3864077.hunt.repository;

import com.s3864077.hunt.model.Inventory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {

    // find between start and end date
    @Query("SELECT i FROM Inventory i WHERE i.startDate BETWEEN ?1 AND ?2")
    Page<Inventory> findAllByStartDateBetween(Pageable pageable);
}
