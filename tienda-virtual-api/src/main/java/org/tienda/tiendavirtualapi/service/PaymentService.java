package org.tienda.tiendavirtualapi.service;

import org.tienda.tiendavirtualapi.model.Payment;
import org.tienda.tiendavirtualapi.model.dto.PaymentDto;
import org.tienda.tiendavirtualapi.model.utils.PaymentId;

import java.util.List;

public interface PaymentService {
    List<PaymentDto> getAllPayments();
    PaymentDto getPaymentById(PaymentId id);
    PaymentDto createPayment(Payment payment);
    PaymentDto updatePayment(Integer id, Payment payment);
    void deletePayment(PaymentId id);
}
