package br.com.venzel.store.modules.user.user.dtos;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.venzel.store.modules.order.order.dtos.OrderDTO;
import br.com.venzel.store.modules.profile.profile.dtos.SimpleProfileDTO;
import br.com.venzel.store.modules.user.user.entities.types.UserState;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private Long id;

    /* Types */

    private UserState state;

    /* Others */

    private String name;

    private String email;

    /* Timestamps */

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

    /* Cardinalities */

    @JsonBackReference
    private List<OrderDTO> orders = new ArrayList<>();

    @JsonManagedReference
    private SimpleProfileDTO profile;
}
