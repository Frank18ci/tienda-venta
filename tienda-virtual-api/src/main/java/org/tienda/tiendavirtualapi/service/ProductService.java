package org.tienda.tiendavirtualapi.service;

import org.springframework.data.domain.Page;
import org.tienda.tiendavirtualapi.model.Product;
import org.tienda.tiendavirtualapi.model.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();
    Page<ProductDto> getProductsByName(String productName, int page, int size, String sortBy, String direction);
    ProductDto getProductById(String id);
    ProductDto createProduct(Product product);
    ProductDto updateProduct(String id, Product product);
    void deleteProduct(String id);
}
