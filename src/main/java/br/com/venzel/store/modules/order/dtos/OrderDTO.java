package br.com.venzel.store.modules.order.dtos;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {

    private Long id;


    /* Cardinality */

    /* Timestamp */

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;
}
