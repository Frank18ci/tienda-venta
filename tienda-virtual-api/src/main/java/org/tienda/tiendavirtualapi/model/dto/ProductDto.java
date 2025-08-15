package org.tienda.tiendavirtualapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.tienda.tiendavirtualapi.model.Product;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private String productCode;
    private String productName;
    private String productLine;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private Integer quantityInStock;
    private BigDecimal buyPrice;
    private BigDecimal MSRP;
    //private ProductLineDto productLine;

    public static ProductDto fromEntity(Product product){
        return ProductDto.builder()
                .productCode(product.getProductCode())
                .productName(product.getProductName())
                .productLine(product.getProductLine().getProductLine())
                .productScale(product.getProductScale())
                .productVendor(product.getProductVendor())
                .productDescription(product.getProductDescription())
                .quantityInStock(product.getQuantityInStock())
                .buyPrice(product.getBuyPrice())
                .MSRP(product.getMsrp())
                .build();

    }
}
