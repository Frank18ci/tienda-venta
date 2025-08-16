package org.tienda.tiendavirtualapi.service;

import org.tienda.tiendavirtualapi.model.Employe;
import org.tienda.tiendavirtualapi.model.dto.EmployeDto;

import java.util.List;

public interface EmployeService {
    List<EmployeDto> getAllEmployes();
    EmployeDto getEmployeById(Integer id);
    EmployeDto createEmploye(Employe employe);
    EmployeDto updateEmploye(Integer id, Employe employe);
    void deleteEmploye(Integer id);

}
