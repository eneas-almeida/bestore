package br.com.venzel.store.modules.user.use_cases.update_user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.user.assemblers.UserAssembler;
import br.com.venzel.store.modules.user.assemblers.UserDesassembler;
import br.com.venzel.store.modules.user.dtos.UserDTO;
import br.com.venzel.store.modules.user.dtos.UserInputDTO;
import br.com.venzel.store.modules.user.entities.User;
import br.com.venzel.store.modules.user.exceptions.UserNotFoundException;
import br.com.venzel.store.modules.user.repositories.UserRepository;

@Service
public class UpdateUserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserAssembler assembler;

    @Autowired
    private UserDesassembler desassembler;

    @Transactional
    public UserDTO execute(UserInputDTO userInputDTO, Long userId) {
        
        Optional<User> currentUser = repository.findById(userId);

        if (!currentUser.isPresent()) {
            throw new UserNotFoundException("User not found!");
        }

        User user = currentUser.get();

        desassembler.toCopyDomain(userInputDTO, user);

        repository.save(user);

        UserDTO userDTO = assembler.toModel(user);

        return userDTO;
    }
}
