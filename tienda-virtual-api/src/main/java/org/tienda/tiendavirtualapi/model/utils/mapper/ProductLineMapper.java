package org.tienda.tiendavirtualapi.model.utils.mapper;

import org.tienda.tiendavirtualapi.model.ProductLine;
import org.tienda.tiendavirtualapi.model.dto.ProductLineDto;

import java.util.List;

public class ProductLineMapper {
    public static ProductLineDto toDto(ProductLine productLine){
        return ProductLineDto.builder()
                .productLine(productLine.getProductLine())
                .textDescription(productLine.getTextDescription())
                .htmlDescription(productLine.getHtmlDescription())
                .image(productLine.getImage())
                .build();
    }
    public static List<ProductLineDto> toDtoList(List<ProductLine> productLines){
        return productLines.stream().map(ProductLineMapper::toDto).toList();
    }
}
