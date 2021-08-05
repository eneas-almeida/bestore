package br.com.venzel.store.modules.user.address.dtos;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StateDTO {
    
    // private Long id;

    private String name;

    /* Cardinality */
    
    @JsonBackReference
    private List<CityDTO> cities = new ArrayList<>();
}
