package org.tienda.tiendavirtualapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tienda.tiendavirtualapi.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
