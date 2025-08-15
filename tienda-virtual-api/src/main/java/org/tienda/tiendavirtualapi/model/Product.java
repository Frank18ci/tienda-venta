package org.tienda.tiendavirtualapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "productCode", length = 15)
    private String productCode;
    @Column(name = "productName", length = 70, nullable = false)
    private String productName;
    @Column(name = "productScale", length = 10, nullable = false)
    private String productScale;
    @Column(name = "productVendor", length = 50, nullable = false)
    private String productVendor;
    @Column(name = "productDescription", columnDefinition = "TEXT", nullable = false)
    private String productDescription;
    @Column(name = "quantityInStock", columnDefinition = "SMALLINT", nullable = false)
    private Integer quantityInStock;
    @Column(name = "buyPrice", precision = 10, scale = 2, nullable = false)
    private BigDecimal buyPrice;
    @Column(name = "MSRP", precision = 10, scale = 2, nullable = false)
    private BigDecimal msrp;

    @ManyToOne
    @JoinColumn(name = "productLine", referencedColumnName = "productLine", nullable = false)
    private ProductLine productLine;

}
