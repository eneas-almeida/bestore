package br.com.venzel.store.modules.payment.dtos;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.venzel.store.modules.order.dtos.OrderDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDTO {

    /* Attributes */
    
    private Long id;

    private String state;
    
    /* Timestamps */
    
    private OffsetDateTime createdAt;
    
    private OffsetDateTime updatedAt;

    /* Cardinalities */

    @JsonIgnore
    private OrderDTO order;
}
