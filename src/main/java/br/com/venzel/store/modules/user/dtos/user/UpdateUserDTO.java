package br.com.venzel.store.modules.user.dtos.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserDTO {
	
    private String name;

    private String email;
}
