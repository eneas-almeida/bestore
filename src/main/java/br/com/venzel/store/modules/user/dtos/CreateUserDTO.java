package br.com.venzel.store.modules.user.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDTO {

    private Integer type = 1;
	
    private String name;

    private String email;

    private String password;

    private Boolean activated = Boolean.FALSE;

    private Boolean allowed = Boolean.TRUE;
}
