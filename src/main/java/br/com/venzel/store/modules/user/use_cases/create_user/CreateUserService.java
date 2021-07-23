package br.com.venzel.store.modules.user.use_cases.create_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.user.assemblers.UserAssembler;
import br.com.venzel.store.modules.user.assemblers.UserDesassembler;
import br.com.venzel.store.modules.user.dtos.UserDTO;
import br.com.venzel.store.modules.user.dtos.UserInputDTO;
import br.com.venzel.store.modules.user.entities.User;
import br.com.venzel.store.modules.user.repositories.UserRepository;

@Service
public class CreateUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAssembler userAssembler;

    @Autowired
    private UserDesassembler userDesassembler;

    @Transactional
    public UserDTO execute(UserInputDTO userInputDTO) {
        
        User user = userDesassembler.toDomain(userInputDTO);

        user = userRepository.save(user);

        UserDTO userDTO = userAssembler.toModel(user);

        return userDTO;
    }
}
