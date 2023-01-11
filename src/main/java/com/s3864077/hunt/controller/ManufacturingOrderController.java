package com.s3864077.hunt.controller;
import com.s3864077.hunt.model.ManufacturingOrder;
import com.s3864077.hunt.service.ManufacturingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mo")
public class ManufacturingOrderController {

    private final ManufacturingOrderService manufacturingOrderService;

    @Autowired
    public ManufacturingOrderController(ManufacturingOrderService manufacturingOrderService) {
        this.manufacturingOrderService = manufacturingOrderService;
    }

    @GetMapping
    public ResponseEntity<List<ManufacturingOrder>> getAllManufacturingOrders(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sort", defaultValue = "ASC") Sort.Direction sort) {

        Pageable pageable = PageRequest.of(page, size, sort);
        return new ResponseEntity<>(manufacturingOrderService.getAllManufacturingOrders(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManufacturingOrder> getManufacturingOrderById(@PathVariable Long id) {
        Optional<ManufacturingOrder> manufacturingOrder = manufacturingOrderService.getManufacturingOrderById(id);
        if (manufacturingOrder.isPresent()) {
            return new ResponseEntity<>(manufacturingOrder.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ManufacturingOrder> createManufacturingOrder(@Validated @RequestBody ManufacturingOrder manufacturingOrder) {
        return new ResponseEntity<>(manufacturingOrderService.createManufacturingOrder(manufacturingOrder), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ManufacturingOrder> updateManufacturingOrder(@PathVariable Long id, @Validated @RequestBody ManufacturingOrder manufacturingOrder) {
        Optional<ManufacturingOrder> existingManufacturingOrder = manufacturingOrderService.getManufacturingOrderById(id);
        if (existingManufacturingOrder.isPresent()) {
            manufacturingOrder.setId(id);
            return new ResponseEntity<>(manufacturingOrderService.updateManufacturingOrder(manufacturingOrder), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManufacturingOrder(@PathVariable Long id) {
        Optional<ManufacturingOrder> manufacturingOrder = manufacturingOrderService.getManufacturingOrderById(id);
        if (manufacturingOrder.isPresent()) {
            manufacturingOrderService.deleteManufacturingOrder(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

