package br.com.venzel.store.modules.product.dtos.product;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.venzel.store.modules.product.dtos.category.CategoryDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    
    private Long id;

    private String name;

    private Double price;

    private Boolean activated;

     /* Cardinality */

    @JsonManagedReference
    private List<CategoryDTO> categories = new ArrayList<>();

    /* Timestamp */

    private OffsetDateTime updatedAt;

    private OffsetDateTime createdAt;
}
