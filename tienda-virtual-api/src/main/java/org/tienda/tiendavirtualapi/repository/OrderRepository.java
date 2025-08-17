package org.tienda.tiendavirtualapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tienda.tiendavirtualapi.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Page<Order> findByOrderNumberContaining(String orderNumber, Pageable pageable);
}
