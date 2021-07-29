package br.com.venzel.store.modules.user.use_cases.create_user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDTO {
    
    private String name;
    private String Email;
    private String password;
}
