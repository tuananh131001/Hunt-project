package com.s3864077.hunt.controller;

import com.s3864077.hunt.model.MaterialsPurchaseOrder;
import com.s3864077.hunt.service.MaterialsPurchaseOrderService;
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
@CrossOrigin("*")
@RequestMapping("/materials-purchase-orders")
public class MaterialsPurchaseOrderController {

    private final MaterialsPurchaseOrderService materialsPurchaseOrderService;

    @Autowired
    public MaterialsPurchaseOrderController(MaterialsPurchaseOrderService materialsPurchaseOrderService) {
        this.materialsPurchaseOrderService = materialsPurchaseOrderService;
    }

    @GetMapping
    public ResponseEntity<List<MaterialsPurchaseOrder>> getAllMaterialsPurchaseOrders(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sort", defaultValue = "ASC") Sort.Direction sort) {
        Pageable pageable = PageRequest.of(page, size, sort);
        return new ResponseEntity<>(materialsPurchaseOrderService.getAllMaterialsPurchaseOrders(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterialsPurchaseOrder> getMaterialsPurchaseOrderById(@PathVariable Long id) {
        Optional<MaterialsPurchaseOrder> materialsPurchaseOrder = materialsPurchaseOrderService.getMaterialsPurchaseOrderById(id);
        if (materialsPurchaseOrder.isPresent()) {
            return new ResponseEntity<>(materialsPurchaseOrder.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public ResponseEntity<MaterialsPurchaseOrder> createMaterialsPurchaseOrder(@Validated @RequestBody MaterialsPurchaseOrder materialsPurchaseOrder) {
        return new ResponseEntity<>(materialsPurchaseOrderService.createMaterialsPurchaseOrder(materialsPurchaseOrder), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaterialsPurchaseOrder> updateMaterialsPurchaseOrder(@PathVariable Long id, @Validated @RequestBody MaterialsPurchaseOrder materialsPurchaseOrder) {
        Optional<MaterialsPurchaseOrder> existingMaterialsPurchaseOrder = materialsPurchaseOrderService.getMaterialsPurchaseOrderById(id);
        if (existingMaterialsPurchaseOrder.isPresent()) {
            materialsPurchaseOrder.setId(id);
            return new ResponseEntity<>(materialsPurchaseOrderService.updateMaterialsPurchaseOrder(materialsPurchaseOrder), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterialsPurchaseOrder(@PathVariable Long id) {
        Optional<MaterialsPurchaseOrder> materialsPurchaseOrder = materialsPurchaseOrderService.getMaterialsPurchaseOrderById(id);
        if (materialsPurchaseOrder.isPresent()) {
            materialsPurchaseOrderService.deleteMaterialsPurchaseOrder(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
