package br.com.venzel.store.modules.user.use_cases.update_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.venzel.store.modules.user.dtos.UserDTO;
import br.com.venzel.store.modules.user.dtos.UserInputDTO;

@RestController
@RequestMapping("/users")
public class UpdateUserController {

    @Autowired
    private UpdateUserService service;

    @PutMapping("/{userId}")
    public UserDTO handle(@RequestBody UserInputDTO userInputDTO, @PathVariable Long userId) {
        return service.execute(userInputDTO, userId);
    }
}
