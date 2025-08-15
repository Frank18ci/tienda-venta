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
@Table(name = "offices")
public class Office {
    @Id
    @Column(name = "officeCode", length = 10)
    private String officeCode;
    @Column(name = "city", length = 50, nullable = false)
    private String city;
    @Column(name = "phone", length = 50, nullable = false)
    private String phone;
    @Column(name = "addressLine1", length = 50, nullable = false)
    private String addressLine1;
    @Column(name = "addressLine2", length = 50, nullable = true)
    private String addressLine2;
    @Column(name = "state", length = 50, nullable = true)
    private String state;
    @Column(name = "country", length = 50, nullable = false)
    private String country;
    @Column(name = "postalCode", length = 15, nullable = false)
    private String postalCode;
    @Column(name = "territory", length = 10, nullable = false)
    private String territory;


     @OneToMany(mappedBy = "officeCode")
     private List<Employe> employees;
}
