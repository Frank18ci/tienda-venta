package org.tienda.tiendavirtualapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tienda.tiendavirtualapi.model.Payment;
import org.tienda.tiendavirtualapi.model.utils.PaymentId;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, PaymentId> {
}
