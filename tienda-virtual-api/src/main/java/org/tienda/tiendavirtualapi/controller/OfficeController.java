package org.tienda.tiendavirtualapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tienda.tiendavirtualapi.model.Office;
import org.tienda.tiendavirtualapi.service.OfficeService;

@RestController
@RequestMapping("offices")
@RequiredArgsConstructor
public class OfficeController {
    private final OfficeService officeService;
    @GetMapping
    public ResponseEntity<?> getAllOffices() {
        return ResponseEntity.status(HttpStatus.OK).body(officeService.getAllOffices());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOfficeById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(officeService.getOfficeById(id));
    }
    @PostMapping
    public ResponseEntity<?> createOffice(@RequestBody Office office) {
        return ResponseEntity.status(HttpStatus.CREATED).body(officeService.createOffice(office));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateOffice(@PathVariable String id, @RequestBody Office office) {
        return ResponseEntity.status(HttpStatus.OK).body(officeService.updateOffice(id, office));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOffice(@PathVariable String id) {
        officeService.deleteOffice(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
