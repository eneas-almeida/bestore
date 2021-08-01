package br.com.venzel.store.modules.payment.dtos;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDTO {
    
    private Long id;

    private String state;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;
}
