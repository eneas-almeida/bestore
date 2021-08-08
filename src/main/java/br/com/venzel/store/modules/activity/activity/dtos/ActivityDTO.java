package br.com.venzel.store.modules.activity.activity.dtos;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.venzel.store.modules.user.user.dtos.SimpleUserDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActivityDTO {

    private String action;

    /* Timestamps */

    private OffsetDateTime createdAt;

    /* Cardinalities */
    
    @JsonManagedReference
    private SimpleUserDTO user;
}
