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
@Table(name = "productlines")
public class ProductLine {
    @Id
    @Column(name = "productLine", length = 50)
    private String productLine;
    @Column(name = "textDescription", length = 4000, nullable = true)
    private String textDescription;
    @Column(name = "htmlDescription", columnDefinition = "MEDIUMTEXT", nullable = true)
    private String htmlDescription;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] image;

    @OneToMany(mappedBy = "productLine")
    private List<Product> products;
}
