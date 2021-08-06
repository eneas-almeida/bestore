package br.com.venzel.store.modules.user.history.dtos;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.venzel.store.modules.user.user.dtos.UserSimpleDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HistoryDTO {

    /* Attributes */
    
    private String description;

    /* Timestamps */

    private OffsetDateTime createdAt;

    /* Cardinalities */
    
    @JsonManagedReference
    private UserSimpleDTO user;
}
