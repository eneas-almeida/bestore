package br.com.venzel.store.modules.order.dtos;

import java.time.OffsetDateTime;

import br.com.venzel.store.modules.payment.dtos.PaymentDTO;
import br.com.venzel.store.modules.user.dtos.user.UserDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {

    /* Attributes */

    private Long id;

    private Boolean activated;
  
    /* Timestamps */
    
    private OffsetDateTime createdAt;
    
    private OffsetDateTime updatedAt;

    /* Cardinalities */

    private UserDTO user;

    private PaymentDTO payment;
}
