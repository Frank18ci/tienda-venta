package org.tienda.tiendavirtualapi.model.utils.mapper;

import org.tienda.tiendavirtualapi.model.Office;
import org.tienda.tiendavirtualapi.model.dto.OfficeDto;

import java.util.List;

public class OfficeMapper {
    public static OfficeDto toDto(Office office){
        return OfficeDto.builder()
                .officeCode(office.getOfficeCode())
                .city(office.getCity())
                .phone(office.getPhone())
                .addressLine1(office.getAddressLine1())
                .addressLine2(office.getAddressLine2())
                .state(office.getState())
                .country(office.getCountry())
                .postalCode(office.getPostalCode())
                .territory(office.getTerritory())
                .build();
    }
    public static List<OfficeDto> toDtoList(List<Office> offices){
        return offices.stream().map(OfficeMapper::toDto).toList();
    }
}
