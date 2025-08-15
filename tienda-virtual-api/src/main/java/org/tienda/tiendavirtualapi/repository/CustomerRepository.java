package org.tienda.tiendavirtualapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tienda.tiendavirtualapi.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
