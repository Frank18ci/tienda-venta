package org.tienda.tiendavirtualapi.model.utils.mapper;

import org.tienda.tiendavirtualapi.model.Product;
import org.tienda.tiendavirtualapi.model.dto.ProductDto;

import java.util.List;

public class ProductoMapper {
    public static ProductDto toDto(Product product){
        return ProductDto.builder()
                .productCode(product.getProductCode())
                .productName(product.getProductName())
                .productScale(product.getProductScale())
                .productVendor(product.getProductVendor())
                .productDescription(product.getProductDescription())
                .quantityInStock(product.getQuantityInStock())
                .buyPrice(product.getBuyPrice())
                .msrp(product.getMsrp())
                .build();
    }
    public static List<ProductDto> toDtoList(List<Product> products) {
        return products.stream()
                .map(ProductoMapper::toDto)
                .toList();
    }
}
