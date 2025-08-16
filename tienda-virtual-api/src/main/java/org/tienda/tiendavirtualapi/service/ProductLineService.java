package org.tienda.tiendavirtualapi.service;

import org.tienda.tiendavirtualapi.model.ProductLine;
import org.tienda.tiendavirtualapi.model.dto.ProductLineDto;

import java.util.List;

public interface ProductLineService {
    List<ProductLineDto> getAllProductLines();
    ProductLineDto getProductLineById(String id);
    ProductLineDto createProductLine(ProductLine productLine);
    ProductLineDto updateProductLine(String id, ProductLine productLine);
    void deleteProductLine(String id);
}
