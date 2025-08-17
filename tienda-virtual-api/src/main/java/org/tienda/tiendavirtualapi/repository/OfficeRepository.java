package org.tienda.tiendavirtualapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tienda.tiendavirtualapi.model.Office;

@Repository
public interface OfficeRepository extends JpaRepository<Office, String> {
    Page<Office> findByCityContaining(String city, Pageable pageable);
}
