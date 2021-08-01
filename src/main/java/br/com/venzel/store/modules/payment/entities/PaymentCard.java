package br.com.venzel.store.modules.payment.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentCard extends Payment {
    
    /* Attributes */

    public static final String name = "Payment with card";

    private Integer numberInstallments;
}
