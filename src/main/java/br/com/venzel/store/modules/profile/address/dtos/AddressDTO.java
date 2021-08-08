package br.com.venzel.store.modules.profile.address.dtos;

import java.time.OffsetDateTime;

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

    private String city;
    
    private String state;

    /* Timestamps */
    
    private OffsetDateTime createdAt;
    
    private OffsetDateTime updatedAt;
}
