package org.tienda.tiendavirtualapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tienda.tiendavirtualapi.model.Employe;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Integer> {
}
