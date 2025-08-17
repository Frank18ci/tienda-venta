package org.tienda.tiendavirtualapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tienda.tiendavirtualapi.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Page<Product> findByProductNameContaining(String productName, Pageable pageable);
}
