package br.com.venzel.store.modules.payment.entities;

import java.time.OffsetDateTime;

import javax.persistence.Column;

import lombok.Getter;

@Getter
public class PaymentBillet extends Payment {

    /* Attributes */

    public static final String name = "Payment with billet";
    
    @Column(nullable = true, columnDefinition = "datetime")
    private OffsetDateTime dueDate;
    
    @Column(nullable = true, columnDefinition = "datetime")
    private OffsetDateTime payDay;
}
