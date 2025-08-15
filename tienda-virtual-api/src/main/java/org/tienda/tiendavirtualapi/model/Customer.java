package org.tienda.tiendavirtualapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @Column(name = "customerNumber")
    private Integer customerNumber;
    @Column(name = "customerName", length = 50, nullable = false)
    private String customerName;
    @Column(name = "contactLastName", length = 50, nullable = false)
    private String contactLastName;
    @Column(name = "contactFirstName", length = 50, nullable = false)
    private String contactFirstName;
    @Column(name = "phone", length = 50, nullable = false)
    private String phone;
    @Column(name = "addressLine1", length = 50, nullable = false)
    private String addressLine1;
    @Column(name = "addressLine2", length = 50, nullable = true)
    private String addressLine2;
    @Column(name = "city", length = 50, nullable = false)
    private String city;
    @Column(name = "state", length = 50, nullable = true)
    private String state;
    @Column(name = "postalCode", length = 15, nullable = true)
    private String postalCode;
    @Column(name = "country", length = 50, nullable = false)
    private String country;
    @Column(name = "creditLimit", nullable = true)
    private Double creditLimit;

    @ManyToOne
    @JoinColumn(name = "salesRepEmployeeNumber", referencedColumnName = "employeeNumber", nullable = true)
    private Employe salesRepEmployeeNumber;

    @OneToMany(mappedBy = "customer")
    @JoinColumn(name = "customerNumber", referencedColumnName = "customerNumber", insertable = false, updatable = false)
    private List<Payment> payments;

    @OneToMany(mappedBy = "customer")
    @JoinColumn(name = "customerNumber", referencedColumnName = "customerNumber", insertable = false, updatable = false)
    private List<Order> orders;
}
