package br.com.venzel.store.modules.user.address.dtos;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.venzel.store.modules.user.user.dtos.UserDTO;
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

    /* Timestamps */
    
    private OffsetDateTime createdAt;
    
    private OffsetDateTime updatedAt;
    
    /* Cardinalities */
    
    @JsonBackReference
    private UserDTO user;
    
    private CityDTO city;
}
