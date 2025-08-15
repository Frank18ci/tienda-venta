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
@Table(name = "employees")
public class Employe {
    @Id
    @Column(name = "employeeNumber")
    private Integer employeeNumber;
    @Column(name = "lastName", length = 50, nullable = false)
    private String lastName;
    @Column(name = "firstName", length = 50, nullable = false)
    private String firstName;
    @Column(name = "extension", length = 10, nullable = false)
    private String extension;
    @Column(name = "email", length = 100, nullable = false)
    private String email;
    @Column(name = "officeCode", length = 10, nullable = false)
    private String officeCode;

    @ManyToOne
    @JoinColumn(name = "reportsTo", referencedColumnName = "employeeNumber", nullable = true)
    private Employe reportsTo;

    @ManyToOne
    @JoinColumn(name = "jobTitle", referencedColumnName = "officeCode", nullable = false)
    private Office jobTitle;

    @OneToMany(mappedBy = "salesRepEmployeeNumber")
    private List<Customer> customers;
}

