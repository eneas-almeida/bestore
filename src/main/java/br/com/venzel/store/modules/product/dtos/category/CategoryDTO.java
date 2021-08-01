package br.com.venzel.store.modules.product.dtos.category;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.venzel.store.modules.product.dtos.product.ProductDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {
    
    private Long id;

    private String name;

    /* Cardinality */

    @JsonBackReference
    private List<ProductDTO> products = new ArrayList<>();

    /* Timestamp */

    private OffsetDateTime createdAt;
}
