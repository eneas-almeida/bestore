package br.com.venzel.store.modules.user.user.dtos;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.venzel.store.modules.order.order.dtos.OrderDTO;
import br.com.venzel.store.modules.user.address.dtos.AddressDTO;
import br.com.venzel.store.modules.user.user.entities.types.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    /* Attributes */
	
    private Long id;

    private UserType type;

    private String name;

    private String email;

    private Boolean activated;

    private Boolean allowed;

    /* Timestamps */

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

     /* Elements collections */

    private Set<String> telephones = new HashSet<>();

    /* Cardinalities */

    @JsonBackReference
    private List<OrderDTO> orders = new ArrayList<>();

    @JsonManagedReference
    private List<AddressDTO> adresses = new ArrayList<>();
}
