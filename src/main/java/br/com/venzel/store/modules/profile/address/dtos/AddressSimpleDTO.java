package br.com.venzel.store.modules.profile.address.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressSimpleDTO {
        
        private String publicPlace;
    
        private String number;
    
        private String complement;
    
        private String district;
    
        private String zipCode;
    
        private String city;
        
        private String state;
}
