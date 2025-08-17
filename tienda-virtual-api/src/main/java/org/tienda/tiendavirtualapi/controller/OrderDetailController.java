package org.tienda.tiendavirtualapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tienda.tiendavirtualapi.service.OrderDetailService;

@RestController
@RequestMapping("/order-details")
@RequiredArgsConstructor
public class OrderDetailController {
    private final OrderDetailService orderDetailService;
}
