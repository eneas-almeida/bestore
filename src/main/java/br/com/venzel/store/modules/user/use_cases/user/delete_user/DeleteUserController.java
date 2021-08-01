package br.com.venzel.store.modules.user.use_cases.user.delete_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.venzel.store.modules.user.dtos.user.UserDTO;

@RestController
@RequestMapping("/users")
public class DeleteUserController {

    @Autowired
    private DeleteUserService deleteUserService;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO handle(@PathVariable Long id) {

        return deleteUserService.execute(id);
    }
}
