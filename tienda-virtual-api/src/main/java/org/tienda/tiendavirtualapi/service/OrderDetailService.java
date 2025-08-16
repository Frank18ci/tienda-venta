package org.tienda.tiendavirtualapi.service;

import org.tienda.tiendavirtualapi.model.OrderDetail;
import org.tienda.tiendavirtualapi.model.dto.OrderDetailDto;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetailDto> getAllOrderDetails();
    OrderDetailDto getOrderDetailById(Integer id);
    OrderDetailDto createOrderDetail(OrderDetail orderDetail);
    OrderDetailDto updateOrderDetail(Integer id, OrderDetail orderDetail);
    void deleteOrderDetail(Integer id);
}
