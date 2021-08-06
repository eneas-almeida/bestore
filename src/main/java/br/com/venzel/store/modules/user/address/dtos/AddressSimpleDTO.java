package br.com.venzel.store.modules.user.address.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.venzel.store.modules.user.user.dtos.UserDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressSimpleDTO {
        
        /* Attributes */

        private String publicPlace;
    
        private String number;
    
        private String complement;
    
        private String district;
    
        private String zipCode;
    
        private String city;
        
        private String state;
    
        /* Cardinalities */
        
        @JsonBackReference
        private UserDTO user;
}
