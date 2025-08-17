package org.tienda.tiendavirtualapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tienda.tiendavirtualapi.model.ProductLine;

@Repository
public interface ProductLineRepository extends JpaRepository<ProductLine, String> {
    Page<ProductLine> findByProductLineContaining(String productLine, Pageable pageable);
}
