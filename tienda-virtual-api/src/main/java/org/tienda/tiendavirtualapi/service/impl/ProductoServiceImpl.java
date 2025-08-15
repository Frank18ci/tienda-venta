package org.tienda.tiendavirtualapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tienda.tiendavirtualapi.exception.types.ResourceFound;
import org.tienda.tiendavirtualapi.exception.types.ResourceNotFound;
import org.tienda.tiendavirtualapi.model.Product;
import org.tienda.tiendavirtualapi.model.dto.ProductDto;
import org.tienda.tiendavirtualapi.repository.ProductRepository;
import org.tienda.tiendavirtualapi.service.ProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductService {
    private final ProductRepository productRepository;


    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(ProductDto::fromEntity).toList();
    }

    @Override
    public ProductDto getProductById(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Product not found with id: " + id));

        return ProductDto.fromEntity(product);
    }

    @Override
    public Product createProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getProductCode())
                .orElse(null);
        if (existingProduct != null) {
            throw new ResourceFound("Product already exists with code: " + product.getProductCode());
        }
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(String id, Product product) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Product not found with id: " + id));

        existingProduct.setProductName(product.getProductName());
        existingProduct.setProductLine(product.getProductLine());
        existingProduct.setProductScale(product.getProductScale());
        existingProduct.setProductVendor(product.getProductVendor());
        existingProduct.setProductDescription(product.getProductDescription());
        existingProduct.setQuantityInStock(product.getQuantityInStock());
        existingProduct.setBuyPrice(product.getBuyPrice());
        existingProduct.setMsrp(product.getMsrp());
        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(String id) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Product not found with id: " + id));

        productRepository.delete(existingProduct);
    }
}
