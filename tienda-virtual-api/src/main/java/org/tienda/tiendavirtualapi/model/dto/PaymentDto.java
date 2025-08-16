package org.tienda.tiendavirtualapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDto {
    private Integer customerNumber;
    private String checkNumber;
    private Date paymentDate;
    private BigDecimal amount;
    private CustomerDto customer;

}
