package br.com.venzel.store.modules.payment.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDTO {
    
    private Long id;

    private String paymentState;
}
