package br.com.venzel.store.modules.user.user.dtos;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.venzel.store.modules.order.order.dtos.OrderDTO;
import br.com.venzel.store.modules.user.profile.profile.dtos.ProfileDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    /* Attributes */
	
    private Long id;

    private String name;

    private String email;

    private Boolean activated;

    private Boolean allowed;

    /* Timestamps */

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

     /* Elements collections */

    // private Set<String> telephones = new HashSet<>();

    /* Cardinalities */

    @JsonBackReference
    private List<OrderDTO> orders = new ArrayList<>();

    // @JsonManagedReference
    // private List<AddressSimpleDTO> adresses = new ArrayList<>();

    @JsonManagedReference
    private ProfileDTO profile;
}
