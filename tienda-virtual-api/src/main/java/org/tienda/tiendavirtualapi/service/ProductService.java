package org.tienda.tiendavirtualapi.service;

import org.tienda.tiendavirtualapi.model.Product;
import org.tienda.tiendavirtualapi.model.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();
    ProductDto getProductById(String id);
    Product createProduct(Product product);
    Product updateProduct(String id, Product product);
    void deleteProduct(String id);
}
