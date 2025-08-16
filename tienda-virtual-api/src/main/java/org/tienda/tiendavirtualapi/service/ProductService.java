package org.tienda.tiendavirtualapi.service;

import org.tienda.tiendavirtualapi.model.Product;
import org.tienda.tiendavirtualapi.model.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();
    ProductDto getProductById(String id);
    ProductDto createProduct(Product product);
    ProductDto updateProduct(String id, Product product);
    void deleteProduct(String id);
}
