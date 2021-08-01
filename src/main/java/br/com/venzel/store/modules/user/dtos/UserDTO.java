package br.com.venzel.store.modules.user.dtos;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.venzel.store.modules.address.dtos.address.AddressDTO;
import br.com.venzel.store.modules.user.entities.types.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
	
    private Long id;

    private UserType type;

    private String name;

    private String email;

    private String document;

    private String avatar;

    private Boolean activated;

    private Boolean allowed;

    /* Cardinality */

    @JsonManagedReference
    private List<AddressDTO> adresses = new ArrayList<>();

    /* Timestamp */

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;
}
