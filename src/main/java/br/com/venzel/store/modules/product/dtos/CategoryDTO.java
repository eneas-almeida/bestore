package br.com.venzel.store.modules.product.dtos;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {
    
    private Long id;

    private String name;

    @JsonBackReference
    private List<ProductDTO> products = new ArrayList<>();

    private OffsetDateTime createdAt;
}
