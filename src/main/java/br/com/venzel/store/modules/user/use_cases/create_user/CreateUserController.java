package br.com.venzel.store.modules.user.use_cases.create_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.venzel.store.modules.user.dtos.UserDTO;

@RestController
@RequestMapping("/users")
public class CreateUserController {

    @Autowired
    private CreateUserService createUserService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO handle(@RequestBody CreateUserDTO dto) {

        UserDTO userModel = createUserService.execute(dto);
        
        return userModel;
    }
}
