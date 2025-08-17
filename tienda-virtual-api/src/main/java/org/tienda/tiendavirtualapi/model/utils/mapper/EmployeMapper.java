package org.tienda.tiendavirtualapi.model.utils.mapper;

import org.tienda.tiendavirtualapi.model.Employe;
import org.tienda.tiendavirtualapi.model.dto.EmployeDto;

import java.util.List;

public class EmployeMapper {
    public static EmployeDto toDto(Employe employe){
        return EmployeDto.builder()
                .employeeNumber(employe.getEmployeeNumber())
                .lastName(employe.getLastName())
                .firstName(employe.getFirstName())
                .extension(employe.getExtension())
                .email(employe.getEmail())
                .officeCode(employe.getOfficeCode())
                .reportsTo(EmployeMapper.toDto(employe.getReportsTo()))
                .jobTitle(OfficeMapper.toDto(employe.getJobTitle()))
                .build();
    }
    public static List<EmployeDto> toDtoList(List<Employe> employes){
        return employes.stream().map(EmployeMapper::toDto).toList();
    }

}
