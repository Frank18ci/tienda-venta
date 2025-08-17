package org.tienda.tiendavirtualapi.model.utils.mapper;

import org.tienda.tiendavirtualapi.model.Order;
import org.tienda.tiendavirtualapi.model.dto.OrderDto;

import java.util.List;

public class OrderMapper {
    public static OrderDto toDto(Order order) {
        return OrderDto.builder()
                .orderNumber(order.getOrderNumber())
                .orderDate(order.getOrderDate())
                .requiredDate(order.getRequiredDate())
                .shippedDate(order.getShippedDate())
                .status(order.getStatus())
                .comments(order.getComments())
                .customer(CustomerMapper.toDto(order.getCustomer()))
                .build();
    }
    public static List<OrderDto> toDtoList(List<Order> orders) {
        return orders.stream()
                .map(OrderMapper::toDto)
                .toList();
    }
}
