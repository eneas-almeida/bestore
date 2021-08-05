package br.com.venzel.store.modules.payment.payment.dtos;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.venzel.store.modules.order.order.dtos.OrderDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDTO {

    /* Attributes */
    
    private Long id;

    private String state;

    private String name;
    
    /* Timestamps */
    
    private OffsetDateTime createdAt;
    
    private OffsetDateTime updatedAt;

    /* Cardinalities */

    @JsonBackReference
    private OrderDTO order;
}
