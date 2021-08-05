package br.com.venzel.store.modules.product.category.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductDTO {

    private String name;

    private Double price;

    private Boolean activated = Boolean.TRUE;
}
