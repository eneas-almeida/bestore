package br.com.venzel.store.modules.product.dtos;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    
    private Long id;

    private String name;

    private Double price;

    private Boolean activated;

    @JsonManagedReference
    private List<CategoryDTO> categories = new ArrayList<>();

    private OffsetDateTime updatedAt;

    private OffsetDateTime createdAt;
}
