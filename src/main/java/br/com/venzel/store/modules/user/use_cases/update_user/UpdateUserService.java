package br.com.venzel.store.modules.user.use_cases.update_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.user.assemblers.UserAssembler;
import br.com.venzel.store.modules.user.assemblers.UserDesassembler;
import br.com.venzel.store.modules.user.dtos.UserDTO;
import br.com.venzel.store.modules.user.entities.User;
import br.com.venzel.store.modules.user.exceptions.UserNotFoundException;
import br.com.venzel.store.modules.user.repositories.UserRepository;

@Service
public class UpdateUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAssembler userAssembler;

    @Autowired
    private UserDesassembler userDesassembler;

    @Transactional
    public UserDTO execute(UpdateUserDTO dto, Long userId) {
        
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found!"));

        userDesassembler.toCopyDomain(dto, user);

        userRepository.save(user);

        UserDTO userModel = userAssembler.toModel(user);

        return userModel;
    }
}
