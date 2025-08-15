package org.tienda.tiendavirtualapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.tienda.tiendavirtualapi.model.utils.PaymentId;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "payments")
@IdClass(PaymentId.class)
public class Payment {
    @Id
    @Column(name = "customerNumber")
    private Integer customerNumber;
    @Id
    @Column(name = "checkNumber", length = 50)
    private String checkNumber;
    @Temporal(TemporalType.DATE)
    @Column(name = "paymentDate")
    private Date paymentDate;
    @Column(name = "amount", precision = 10, scale = 2, nullable = false)
    private BigDecimal amount;
    @ManyToOne
    @JoinColumn(name = "customerNumber", referencedColumnName = "customerNumber", insertable = false, updatable = false)
    private Customer customer;


}
