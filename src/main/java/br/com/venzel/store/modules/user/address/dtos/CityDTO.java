package br.com.venzel.store.modules.user.address.dtos;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityDTO {

    // private Long id;

    private String name;

    /* Cardinality */

    @JsonManagedReference
    private StateDTO state;
}
