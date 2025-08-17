package org.tienda.tiendavirtualapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tienda.tiendavirtualapi.exception.types.ResourceNotFound;
import org.tienda.tiendavirtualapi.model.Office;
import org.tienda.tiendavirtualapi.model.dto.OfficeDto;
import org.tienda.tiendavirtualapi.model.utils.mapper.OfficeMapper;
import org.tienda.tiendavirtualapi.repository.OfficeRepository;
import org.tienda.tiendavirtualapi.service.OfficeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfficeServiceImpl implements OfficeService {
    private final OfficeRepository officeRepository;

    @Override
    public List<OfficeDto> getAllOffices() {
        return OfficeMapper.toDtoList(officeRepository.findAll());
    }

    @Override
    public OfficeDto getOfficeById(String id) {
        return OfficeMapper.toDto(officeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Office not found with id: " + id)));
    }

    @Override
    public OfficeDto createOffice(Office office) {
        return OfficeMapper.toDto(officeRepository.save(office));
    }

    @Override
    public OfficeDto updateOffice(String id, Office office) {
        Office existingOffice = officeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Office not found with id: " + id));

        existingOffice.setOfficeCode(office.getOfficeCode());
        existingOffice.setCity(office.getCity());
        existingOffice.setPhone(office.getPhone());
        existingOffice.setAddressLine1(office.getAddressLine1());
        existingOffice.setAddressLine2(office.getAddressLine2());
        existingOffice.setState(office.getState());
        existingOffice.setCountry(office.getCountry());
        existingOffice.setPostalCode(office.getPostalCode());
        existingOffice.setTerritory(office.getTerritory());
        Office updatedOffice = officeRepository.save(existingOffice);

        return OfficeMapper.toDto(updatedOffice);
    }

    @Override
    public void deleteOffice(String id) {
        if (!officeRepository.existsById(id)) {
            throw new ResourceNotFound("Office not found with id: " + id);
        }
        officeRepository.deleteById(id);
    }
}
