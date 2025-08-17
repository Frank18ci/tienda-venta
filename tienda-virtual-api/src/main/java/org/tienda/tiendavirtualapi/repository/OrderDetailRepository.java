package org.tienda.tiendavirtualapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tienda.tiendavirtualapi.model.OrderDetail;
import org.tienda.tiendavirtualapi.model.utils.OrderDetailId;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {
    Page<OrderDetail> findByProductCodeContaining(String productCode, Pageable pageable);
}
