package br.com.venzel.store.modules.user.user.use_cases.list_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.venzel.store.modules.user.user.dtos.UserDTO;

@RestController
@RequestMapping("/users")
public class ListUserController {
    
    @Autowired
    private ListUserService listUserService;

    @GetMapping
    public Page<UserDTO> handle(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                                @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
                                @RequestParam(value = "direction", defaultValue = "DESC") String direction) {

        return listUserService.execute(page, linesPerPage, orderBy, direction);
    }
}
