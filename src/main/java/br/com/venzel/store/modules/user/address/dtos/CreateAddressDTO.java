package br.com.venzel.store.modules.user.address.dtos;

import br.com.venzel.store.modules.user.user.entities.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAddressDTO {
    
    private String publicPlace;

    private String number;

    private String complement;

    private String district;

    private String zipCode;

    private String city;
    
    private String state;

    private User user;
}
