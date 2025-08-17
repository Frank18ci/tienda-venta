package org.tienda.tiendavirtualapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tienda.tiendavirtualapi.exception.types.ResourceNotFound;
import org.tienda.tiendavirtualapi.model.Order;
import org.tienda.tiendavirtualapi.model.OrderDetail;
import org.tienda.tiendavirtualapi.model.dto.OrderDetailDto;
import org.tienda.tiendavirtualapi.model.dto.OrderDto;
import org.tienda.tiendavirtualapi.model.utils.OrderDetailId;
import org.tienda.tiendavirtualapi.model.utils.mapper.OrderMapper;
import org.tienda.tiendavirtualapi.repository.OrderDetailRepository;
import org.tienda.tiendavirtualapi.repository.OrderRepository;
import org.tienda.tiendavirtualapi.service.OrderDetailService;
import org.tienda.tiendavirtualapi.service.OrderService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public List<OrderDto> getAllOrders() {
        return OrderMapper.toDtoList(orderRepository.findAll());
    }

    @Override
    public OrderDto getOrderById(Integer id) {
        return OrderMapper.toDto(orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Order not found with id: " + id)));
    }

    @Override
    public OrderDto createOrder(Order order) {
        return OrderMapper.toDto(orderRepository.save(order));
    }

    @Override
    public OrderDto updateOrder(Integer id, Order order) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Order not found with id: " + id));
        existingOrder.setOrderDate(order.getOrderDate());
        existingOrder.setRequiredDate(order.getRequiredDate());
        existingOrder.setShippedDate(order.getShippedDate());
        existingOrder.setStatus(order.getStatus());
        existingOrder.setComments(order.getComments());
        Order updatedOrder = orderRepository.save(existingOrder);
        return OrderMapper.toDto(updatedOrder);
    }

    @Override
    public void deleteOrder(Integer id) {
        if (!orderRepository.existsById(id)) {
            throw new ResourceNotFound("Order not found with id: " + id);
        }
        orderRepository.deleteById(id);
    }
}