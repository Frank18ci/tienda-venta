package org.tienda.tiendavirtualapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tienda.tiendavirtualapi.model.ProductLine;
import org.tienda.tiendavirtualapi.service.ProductLineService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product-lines")
public class ProductLineController {
    private final ProductLineService productLineService;

    @GetMapping
    public ResponseEntity<?> getAllProductLines() {
        return ResponseEntity.status(HttpStatus.OK).body(productLineService.getAllProductLines());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductLineById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(productLineService.getProductLineById(id));
    }
    @PostMapping
    public ResponseEntity<?> createProductLine(@RequestBody ProductLine productLine) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productLineService.createProductLine(productLine));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProductLine(@PathVariable String id, @RequestBody ProductLine productLine) {
        return ResponseEntity.status(HttpStatus.OK).body(productLineService.updateProductLine(id, productLine));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductLine(@PathVariable String id) {
        productLineService.deleteProductLine(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
