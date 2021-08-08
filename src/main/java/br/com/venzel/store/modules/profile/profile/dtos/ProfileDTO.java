package br.com.venzel.store.modules.profile.profile.dtos;

import java.util.ArrayList;
import java.util.List;

import br.com.venzel.store.modules.profile.address.dtos.AddressDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileDTO {
    
    /* Attributes */

    private Long id;

    /* Cardinalities */

    private List<AddressDTO> adresses = new ArrayList<>();
}
