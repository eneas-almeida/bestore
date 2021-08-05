package br.com.venzel.store.modules.product.product.dtos;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.venzel.store.modules.product.category.dtos.CategoryDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    /* Attributes */
    
    private Long id;

    private String name;

    private Double price;

    private Boolean activated;
    
    /* Timestamps */
    
    private OffsetDateTime updatedAt;
    
    private OffsetDateTime createdAt;
    
    /* Cardinalities */

    @JsonBackReference
    private List<CategoryDTO> categories = new ArrayList<>();
}
