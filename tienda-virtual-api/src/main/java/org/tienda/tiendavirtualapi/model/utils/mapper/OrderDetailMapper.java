package org.tienda.tiendavirtualapi.model.utils.mapper;

import org.tienda.tiendavirtualapi.model.OrderDetail;
import org.tienda.tiendavirtualapi.model.dto.OrderDetailDto;

import java.util.List;

public class OrderDetailMapper {
    public static OrderDetailDto toDto(OrderDetail orderDetail) {
        return OrderDetailDto.builder()
                .orderNumber(orderDetail.getOrderNumber())
                .productCode(orderDetail.getProductCode())
                .quantityOrdered(orderDetail.getQuantityOrdered())
                .priceEach(orderDetail.getPriceEach())
                .orderLineNumber(orderDetail.getOrderLineNumber())
                .order(OrderMapper.toDto(orderDetail.getOrder()))
                .product(ProductMapper.toDto(orderDetail.getProduct()))
                .build();
    }
    public static List<OrderDetailDto> toDtoList(List<OrderDetail> orderDetails) {
        return orderDetails.stream().map(OrderDetailMapper::toDto).toList();
    }
}
