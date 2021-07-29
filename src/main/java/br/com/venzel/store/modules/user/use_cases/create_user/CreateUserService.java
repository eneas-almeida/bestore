package br.com.venzel.store.modules.user.use_cases.create_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.user.assemblers.UserAssembler;
import br.com.venzel.store.modules.user.assemblers.UserDesassembler;
import br.com.venzel.store.modules.user.dtos.UserDTO;
import br.com.venzel.store.modules.user.entities.User;
import br.com.venzel.store.modules.user.providers.hash_provider.HashProvider;
import br.com.venzel.store.modules.user.repositories.UserRepository;

@Service
public class CreateUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAssembler userAssembler;

    @Autowired
    private UserDesassembler userDesassembler;

    @Qualifier("mockHashProvider")
    @Autowired
    private HashProvider hashProvider;

    @Transactional
    public UserDTO execute(CreateUserDTO dto) {

        User user = userDesassembler.toDomain(dto);

        String passwordGenerated = hashProvider.generateHash(dto.getPassword());

        user.setPassword(passwordGenerated);

        user = userRepository.save(user);

        UserDTO userModel = userAssembler.toModel(user);

        return userModel;
    }
}
