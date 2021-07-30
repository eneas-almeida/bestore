package br.com.venzel.store.modules.user.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
	
    private Long id;

    private String name;

    private String email;

    private String birthday;

    private String password;

    private String avatar;

    private Boolean activated;

    private Boolean allowed;
}
