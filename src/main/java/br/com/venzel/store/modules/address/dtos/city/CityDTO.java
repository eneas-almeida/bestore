package br.com.venzel.store.modules.address.dtos.city;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.venzel.store.modules.address.dtos.state.StateDTO;
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
