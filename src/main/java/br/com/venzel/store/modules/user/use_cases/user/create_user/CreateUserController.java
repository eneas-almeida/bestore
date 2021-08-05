package br.com.venzel.store.modules.user.use_cases.user.create_user;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.venzel.store.modules.user.dtos.user.CreateUserDTO;
import br.com.venzel.store.modules.user.dtos.user.UserDTO;

@RestController
@RequestMapping("/users")
public class CreateUserController {

    @Autowired
    private CreateUserService createUserService;

    // @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Void> handle(@RequestBody CreateUserDTO dto) {

        UserDTO userDTO = createUserService.execute(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(userDTO.getId())
                        .toUri();

        return ResponseEntity.created(uri).build();
    }
}
