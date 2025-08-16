package org.tienda.tiendavirtualapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tienda.tiendavirtualapi.model.Product;
import org.tienda.tiendavirtualapi.model.ProductLine;
import org.tienda.tiendavirtualapi.model.dto.ProductDto;
import org.tienda.tiendavirtualapi.model.dto.ProductLineDto;
import org.tienda.tiendavirtualapi.model.utils.mapper.ProductLineMapper;
import org.tienda.tiendavirtualapi.repository.ProductLineRepository;
import org.tienda.tiendavirtualapi.service.ProductLineService;
import org.tienda.tiendavirtualapi.service.ProductService;

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
        return null;
    }

    @Override
    public ProductLineDto createProductLine(ProductLine productLine) {
        return null;
    }

    @Override
    public ProductLineDto updateProductLine(String id, ProductLine productLine) {
        return null;
    }

    @Override
    public void deleteProductLine(String id) {

    }
}