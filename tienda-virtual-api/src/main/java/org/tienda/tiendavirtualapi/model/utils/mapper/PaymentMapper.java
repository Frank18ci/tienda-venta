package org.tienda.tiendavirtualapi.model.utils.mapper;

import org.tienda.tiendavirtualapi.model.Payment;
import org.tienda.tiendavirtualapi.model.dto.PaymentDto;

import java.util.List;

public class PaymentMapper {
    public static PaymentDto toDto(Payment payment) {
        return PaymentDto.builder()
                .customerNumber(payment.getCustomerNumber())
                .checkNumber(payment.getCheckNumber())
                .paymentDate(payment.getPaymentDate())
                .amount(payment.getAmount())
                .build();
    }
    public static List<PaymentDto> toDtoList(List<Payment> payments) {
        return payments.stream()
                .map(PaymentMapper::toDto)
                .toList();
    }
}
