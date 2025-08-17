package org.tienda.tiendavirtualapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tienda.tiendavirtualapi.exception.types.ResourceNotFound;
import org.tienda.tiendavirtualapi.model.Employe;
import org.tienda.tiendavirtualapi.model.dto.EmployeDto;
import org.tienda.tiendavirtualapi.model.utils.mapper.EmployeMapper;
import org.tienda.tiendavirtualapi.repository.EmployeRepository;
import org.tienda.tiendavirtualapi.service.EmployeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeServiceImpl implements EmployeService {
    private final EmployeRepository employeRepository;

    @Override
    public List<EmployeDto> getAllEmployes() {
        return EmployeMapper.toDtoList(employeRepository.findAll());
    }

    @Override
    public EmployeDto getEmployeById(Integer id) {
        return EmployeMapper.toDto(employeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Employe not found with id: " + id)));
    }

    @Override
    public EmployeDto createEmploye(Employe employe) {
        return EmployeMapper.toDto(employeRepository.save(employe));
    }

    @Override
    public EmployeDto updateEmploye(Integer id, Employe employe) {
        Employe existingEmploye = employeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Employe not found with id: " + id));

        existingEmploye.setFirstName(employe.getFirstName());
        existingEmploye.setLastName(employe.getLastName());
        existingEmploye.setExtension(employe.getExtension());
        existingEmploye.setEmail(employe.getEmail());
        existingEmploye.setOfficeCode(employe.getOfficeCode());
        existingEmploye.setJobTitle(employe.getJobTitle());
        Employe updatedEmploye = employeRepository.save(existingEmploye);

        return EmployeMapper.toDto(updatedEmploye);
    }

    @Override
    public void deleteEmploye(Integer id) {
        if (!employeRepository.existsById(id)) {
            throw new ResourceNotFound("Employe not found with id: " + id);
        }
        employeRepository.deleteById(id);
    }
}
