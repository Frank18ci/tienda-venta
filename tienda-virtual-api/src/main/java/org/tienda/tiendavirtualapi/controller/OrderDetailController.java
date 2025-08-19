package org.tienda.tiendavirtualapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tienda.tiendavirtualapi.model.OrderDetail;
import org.tienda.tiendavirtualapi.model.utils.OrderDetailId;
import org.tienda.tiendavirtualapi.service.OrderDetailService;

@RestController
@RequestMapping("/order-details")
@RequiredArgsConstructor
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    @GetMapping
    public ResponseEntity<?> getAllOrderDetails() {
        return ResponseEntity.status(HttpStatus.OK).body(orderDetailService.getAllOrderDetails());
    }
    @GetMapping("/{orderNumber}/{productCode}")
    public ResponseEntity<?> getOrderDetailById(@PathVariable  Integer orderNumber, @PathVariable String productCode) {
        return ResponseEntity.status(HttpStatus.OK).body(orderDetailService.getOrderDetailById(new OrderDetailId(orderNumber, productCode)));
    }
    @PostMapping
    public ResponseEntity<?> createOrderDetail(@RequestBody OrderDetail orderDetail) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderDetailService.createOrderDetail(orderDetail));
    }
    @PutMapping("/{orderNumber}/{productCode}")
    public ResponseEntity<?> updateOrderDetail(@PathVariable Integer orderNumber, @PathVariable String productCode, @RequestBody OrderDetail orderDetail) {
        return ResponseEntity.status(HttpStatus.OK).body(orderDetailService.updateOrderDetail(new OrderDetailId(orderNumber, productCode), orderDetail));
    }
    @DeleteMapping("/{orderNumber}/{productCode}")
    public ResponseEntity<?> deleteOrderDetail(@PathVariable Integer orderNumber, @PathVariable String productCode) {
        orderDetailService.deleteOrderDetail(new OrderDetailId(orderNumber, productCode));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
