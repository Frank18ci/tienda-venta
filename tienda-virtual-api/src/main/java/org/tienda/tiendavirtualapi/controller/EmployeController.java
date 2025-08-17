package org.tienda.tiendavirtualapi.controller;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tienda.tiendavirtualapi.model.Employe;
import org.tienda.tiendavirtualapi.service.EmployeService;

@RestController
@RequestMapping("employes")
@RequiredArgsConstructor
public class EmployeController {
    private final EmployeService employeService;
    @GetMapping
    public ResponseEntity<?> getAllEmployes() {
        return ResponseEntity.status(HttpStatus.OK).body(employeService.getAllEmployes());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(employeService.getEmployeById(id));
    }
    @PostMapping
    public ResponseEntity<?> createEmploye(@RequestBody Employe employe) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeService.createEmploye(employe));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmploye(@PathVariable Integer id, @RequestBody Employe employe) {
            return ResponseEntity.status(HttpStatus.OK).body(employeService.updateEmploye(id, employe));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmploye(@PathVariable Integer id) {
        employeService.deleteEmploye(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
