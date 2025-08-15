package org.tienda.tiendavirtualapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductLineDto {
    private String productLine;
    private String textDescription;
    private String htmlDescription;
    private byte[] image;
}
