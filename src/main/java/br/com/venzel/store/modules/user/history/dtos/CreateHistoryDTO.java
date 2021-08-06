package br.com.venzel.store.modules.user.history.dtos;

import br.com.venzel.store.modules.user.user.entities.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateHistoryDTO {
    
    private String description;

    private User user;
}
