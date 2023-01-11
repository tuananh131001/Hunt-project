package com.s3864077.hunt.controller;

import com.s3864077.hunt.model.BillOfMaterial;
import com.s3864077.hunt.service.BillOfMaterialService;
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
@RequestMapping("/bom")
public class BillOfMaterialController {

    private final BillOfMaterialService billOfMaterialService;

    @Autowired
    public BillOfMaterialController(BillOfMaterialService billOfMaterialService) {
        this.billOfMaterialService = billOfMaterialService;
    }

    @GetMapping
    public ResponseEntity<List<BillOfMaterial>> getAllBillOfMaterials(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sort", defaultValue = "ASC") Sort.Direction sort) {
        Pageable pageable = PageRequest.of(page, size, sort);
        return new ResponseEntity<>(billOfMaterialService.getAllBillOfMaterials(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillOfMaterial> getBillOfMaterialById(@PathVariable Long id) {
        Optional<BillOfMaterial> billOfMaterial = billOfMaterialService.getBillOfMaterialById(id);
        if (billOfMaterial.isPresent()) {
            return new ResponseEntity<>(billOfMaterial.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<BillOfMaterial>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<BillOfMaterial> createBillOfMaterial(@Validated @RequestBody BillOfMaterial billOfMaterial) {
        return new ResponseEntity<>(billOfMaterialService.createBillOfMaterial(billOfMaterial), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BillOfMaterial> updateBillOfMaterial(@PathVariable Long id, @Validated @RequestBody BillOfMaterial billOfMaterial) {
        Optional<BillOfMaterial> existingBillOfMaterial = billOfMaterialService.getBillOfMaterialById(id);
        if (existingBillOfMaterial.isPresent()) {
            billOfMaterial.setId(id);
            return new ResponseEntity<>(billOfMaterialService.updateBillOfMaterial(billOfMaterial), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBillOfMaterial(@PathVariable Long id) {
        Optional<BillOfMaterial> billOfMaterial = billOfMaterialService.getBillOfMaterialById(id);
        if (billOfMaterial.isPresent()) {
            billOfMaterialService.deleteBillOfMaterial(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


