package br.com.venzel.store.modules.user.user.dtos;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.venzel.store.modules.user.history.dtos.HistoryDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSimpleDTO {

    /* Attributes */

    private String name;

    private String avatar;

    /* Cardinalities */
    
    @JsonBackReference
    private List<HistoryDTO> histories = new ArrayList<>();
}
