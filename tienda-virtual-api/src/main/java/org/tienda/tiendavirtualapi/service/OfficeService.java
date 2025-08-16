package org.tienda.tiendavirtualapi.service;

import org.tienda.tiendavirtualapi.model.Office;
import org.tienda.tiendavirtualapi.model.dto.OfficeDto;

import java.util.List;

public interface OfficeService {
    List<OfficeDto> getAllOffices();
    OfficeDto getOfficeById(String id);
    OfficeDto createOffice(Office office);
    OfficeDto updateOffice(String id, Office office);
    void deleteOffice(String id);
}
