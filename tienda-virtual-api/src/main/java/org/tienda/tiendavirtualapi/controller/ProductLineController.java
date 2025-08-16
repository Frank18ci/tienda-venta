package org.tienda.tiendavirtualapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
