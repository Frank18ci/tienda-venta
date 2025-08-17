package org.tienda.tiendavirtualapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tienda.tiendavirtualapi.exception.types.ResourceNotFound;
import org.tienda.tiendavirtualapi.model.ProductLine;
import org.tienda.tiendavirtualapi.model.dto.ProductLineDto;
import org.tienda.tiendavirtualapi.model.utils.mapper.ProductLineMapper;
import org.tienda.tiendavirtualapi.repository.ProductLineRepository;
import org.tienda.tiendavirtualapi.service.ProductLineService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductLineServiceImpl implements ProductLineService {
    private final ProductLineRepository productLineRepository;

    @Override
    public List<ProductLineDto> getAllProductLines() {
        return ProductLineMapper.toDtoList(productLineRepository.findAll());
    }

    @Override
    public ProductLineDto getProductLineById(String id) {
        return ProductLineMapper.toDto(productLineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Product line not found with id: " + id)));
    }

    @Override
    public ProductLineDto createProductLine(ProductLine productLine) {
        return ProductLineMapper.toDto(productLineRepository.save(productLine));
    }

    @Override
    public ProductLineDto updateProductLine(String id, ProductLine productLine) {
        ProductLine existingProductLine = productLineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Product line not found with id: " + id));

        existingProductLine.setProductLine(productLine.getProductLine());
        existingProductLine.setTextDescription(productLine.getTextDescription());
        existingProductLine.setHtmlDescription(productLine.getHtmlDescription());
        existingProductLine.setImage(productLine.getImage());
        ProductLine updatedProductLine = productLineRepository.save(existingProductLine);

        return ProductLineMapper.toDto(updatedProductLine);
    }

    @Override
    public void deleteProductLine(String id) {
        if (!productLineRepository.existsById(id)) {
            throw new ResourceNotFound("Product line not found with id: " + id);
        }
        productLineRepository.deleteById(id);
    }
}