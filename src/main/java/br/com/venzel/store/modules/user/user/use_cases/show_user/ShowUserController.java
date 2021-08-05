package br.com.venzel.store.modules.user.user.use_cases.show_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.venzel.store.modules.user.user.dtos.UserDTO;

@RestController
@RequestMapping("/users")
public class ShowUserController {

    @Autowired
    private ShowUserService showUserService;
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO handle(@PathVariable Long id) {

        return showUserService.execute(id);
    }
}
