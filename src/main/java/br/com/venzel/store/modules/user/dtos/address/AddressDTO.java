package br.com.venzel.store.modules.user.dtos.address;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.venzel.store.modules.user.dtos.city.CityDTO;
import br.com.venzel.store.modules.user.dtos.user.UserDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {

    // private Long id;

    private String publicPlace;

    private String number;

    private String complement;

    private String district;

    private String zipCode;

    /* Cardinality */
    
    @JsonBackReference
    private UserDTO user;

    private CityDTO city;

    /* Timestamp */

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;
}
