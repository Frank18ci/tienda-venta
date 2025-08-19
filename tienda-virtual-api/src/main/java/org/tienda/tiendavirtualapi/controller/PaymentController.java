package org.tienda.tiendavirtualapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tienda.tiendavirtualapi.model.Payment;
import org.tienda.tiendavirtualapi.model.utils.PaymentId;
import org.tienda.tiendavirtualapi.service.PaymentService;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping
    public ResponseEntity<?> getAllPayments() {
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.getAllPayments());
    }
    @GetMapping("/{customerNumber}/{checkNumber}")
    public ResponseEntity<?> getPaymentById(@PathVariable Integer customerNumber, @PathVariable String checkNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.getPaymentById(new PaymentId(customerNumber, checkNumber)));
    }
    @PostMapping
    public ResponseEntity<?> createPayment(@RequestBody Payment payment) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.createPayment(payment));
    }
    @PutMapping("/{customerNumber}/{checkNumber}")
    public ResponseEntity<?> updatePayment(@PathVariable Integer customerNumber, @PathVariable String checkNumber, @RequestBody Payment payment) {
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.updatePayment(new PaymentId(customerNumber, checkNumber), payment));
    }
    @DeleteMapping("/{customerNumber}/{checkNumber}")
    public ResponseEntity<?> deletePayment(@PathVariable Integer customerNumber, @PathVariable String checkNumber) {
        paymentService.deletePayment(new PaymentId(customerNumber, checkNumber));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
