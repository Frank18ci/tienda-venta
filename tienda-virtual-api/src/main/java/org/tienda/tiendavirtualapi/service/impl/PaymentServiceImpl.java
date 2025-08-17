package org.tienda.tiendavirtualapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tienda.tiendavirtualapi.exception.types.ResourceNotFound;
import org.tienda.tiendavirtualapi.model.Payment;
import org.tienda.tiendavirtualapi.model.dto.PaymentDto;
import org.tienda.tiendavirtualapi.model.utils.PaymentId;
import org.tienda.tiendavirtualapi.model.utils.mapper.PaymentMapper;
import org.tienda.tiendavirtualapi.repository.PaymentRepository;
import org.tienda.tiendavirtualapi.service.PaymentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    @Override
    public List<PaymentDto> getAllPayments() {
        return PaymentMapper.toDtoList(paymentRepository.findAll());
    }

    @Override
    public PaymentDto getPaymentById(PaymentId id) {
        return PaymentMapper.toDto(paymentRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFound("Payment not found with id: " + id)));
    }

    @Override
    public PaymentDto createPayment(Payment payment) {
        return PaymentMapper.toDto(paymentRepository.save(payment));
    }

    @Override
    public PaymentDto updatePayment(Integer id, Payment payment) {
        Payment existingPayment = paymentRepository.findById(new PaymentId(id, payment.getCheckNumber()))
                .orElseThrow(() -> new ResourceNotFound("Payment not found with id: " + id));

        existingPayment.setCustomerNumber(payment.getCustomerNumber());
        existingPayment.setPaymentDate(payment.getPaymentDate());
        existingPayment.setAmount(payment.getAmount());
        Payment updatedPayment = paymentRepository.save(existingPayment);

        return PaymentMapper.toDto(updatedPayment);
    }

    @Override
    public void deletePayment(PaymentId id) {
        if (!paymentRepository.existsById(id)) {
            throw new ResourceNotFound("Payment not found with id: " + id);
        }
        paymentRepository.deleteById(id);
    }
}
