package org.tienda.tiendavirtualapi.model.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentId implements Serializable {
    private Integer customerNumber;
    private String checkNumber;

}
