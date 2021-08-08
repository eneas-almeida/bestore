package br.com.venzel.store.modules.activity.activity.dtos;

import br.com.venzel.store.modules.user.user.entities.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateActivityDTO {
    
    private String action;

    private User user;
}
