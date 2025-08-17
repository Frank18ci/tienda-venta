package org.tienda.tiendavirtualapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tienda.tiendavirtualapi.exception.types.ResourceNotFound;
import org.tienda.tiendavirtualapi.model.OrderDetail;
import org.tienda.tiendavirtualapi.model.dto.OrderDetailDto;
import org.tienda.tiendavirtualapi.model.utils.OrderDetailId;
import org.tienda.tiendavirtualapi.model.utils.mapper.OrderDetailMapper;
import org.tienda.tiendavirtualapi.repository.OrderDetailRepository;
import org.tienda.tiendavirtualapi.service.OrderDetailService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetailDto> getAllOrderDetails() {
        return OrderDetailMapper.toDtoList(orderDetailRepository.findAll());
    }

    @Override
    public OrderDetailDto getOrderDetailById(OrderDetailId id) {
        return OrderDetailMapper.toDto(orderDetailRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Order detail not found with id: " + id)));
    }

    @Override
    public OrderDetailDto createOrderDetail(OrderDetail orderDetail) {
        return OrderDetailMapper.toDto(orderDetailRepository.save(orderDetail));
    }

    @Override
    public OrderDetailDto updateOrderDetail(Integer id, OrderDetail orderDetail) {
        OrderDetail existingOrderDetail = orderDetailRepository.findById(new OrderDetailId(orderDetail.getOrderNumber(), orderDetail.getProductCode()))
                .orElseThrow(() -> new ResourceNotFound("Order detail not found with id: " + orderDetail.getOrderNumber() + ", " + orderDetail.getProductCode()));

        existingOrderDetail.setQuantityOrdered(orderDetail.getQuantityOrdered());
        existingOrderDetail.setPriceEach(orderDetail.getPriceEach());
        existingOrderDetail.setOrderLineNumber(orderDetail.getOrderLineNumber());
        OrderDetail updatedOrderDetail = orderDetailRepository.save(existingOrderDetail);

        return OrderDetailMapper.toDto(updatedOrderDetail);
    }

    @Override
    public void deleteOrderDetail(OrderDetailId id) {
        if (!orderDetailRepository.existsById(id)) {
            throw new ResourceNotFound("Order detail not found with id: " + id);
        }
        orderDetailRepository.deleteById(id);
    }
}
