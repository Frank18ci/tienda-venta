package org.tienda.tiendavirtualapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.tienda.tiendavirtualapi.model.utils.OrderDetailId;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orderdetails")
@IdClass(OrderDetailId.class)
public class OrderDetail {
    @Id
    @Column(name = "orderNumber", nullable = false)
    private Integer orderNumber;
    @Id
    @Column(name = "productCode", length = 15, nullable = false)
    private String productCode;
    @Column(name = "quantityOrdered", nullable = false)
    private Integer quantityOrdered;
    @Column(name = "priceEach", precision = 10, scale = 2, nullable = false)
    private BigDecimal priceEach;
    @Column(name = "orderLineNumber", columnDefinition = "SMALLINT", nullable = false)
    private Integer orderLineNumber;

    @ManyToOne
    @JoinColumn(name = "orderNumber", referencedColumnName = "orderNumber", insertable = false, updatable = false)
    private Order order;
    @ManyToOne
    @JoinColumn(name = "productCode", referencedColumnName = "productCode", insertable = false, updatable = false)
    private Product product;

}
