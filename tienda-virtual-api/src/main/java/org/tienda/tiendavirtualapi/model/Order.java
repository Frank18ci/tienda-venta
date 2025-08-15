package org.tienda.tiendavirtualapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {
    @Id
    private Integer orderNumber;
    @Temporal(TemporalType.DATE)
    @Column(name = "orderDate", nullable = false)
    private Date orderDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "requiredDate", nullable = false)
    private Date requiredDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "shippedDate", nullable = true)
    private Date shippedDate;
    @Column(name = "status", length = 15, nullable = false)
    private String status;
    @Column(name = "comments", columnDefinition = "TEXT", nullable = true)
    private String comments;
    
    @ManyToOne
    @JoinColumn(name = "customerNumber", referencedColumnName = "customerNumber", nullable = false)
    private Customer customer;
}
