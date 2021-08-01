package br.com.venzel.store.modules.address.dtos.address;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.venzel.store.modules.user.dtos.UserDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {

    private Long id;

    private String publicPlace;

    private String number;

    private String complement;

    private String district;

    private String zipCode;

    /* Cardinality */
    
    @JsonBackReference
    private UserDTO user;

    /* Timestamp */

    // private OffsetDateTime createdAt;

    // private OffsetDateTime updatedAt;
}
