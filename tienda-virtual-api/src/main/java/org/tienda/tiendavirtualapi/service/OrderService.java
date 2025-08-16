package org.tienda.tiendavirtualapi.service;

import org.tienda.tiendavirtualapi.model.Order;
import org.tienda.tiendavirtualapi.model.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> getAllOrders();
    OrderDto getOrderById(Integer id);
    OrderDto createOrder(Order order);
    OrderDto updateOrder(Integer id, Order order);
    void deleteOrder(Integer id);
}
