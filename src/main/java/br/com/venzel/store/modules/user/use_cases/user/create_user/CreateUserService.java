package br.com.venzel.store.modules.user.use_cases.user.create_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.user.dtos.user.CreateUserDTO;
import br.com.venzel.store.modules.user.dtos.user.UserDTO;
import br.com.venzel.store.modules.user.entities.User;
import br.com.venzel.store.modules.user.exceptions.user.UserAlreadyExistsException;
import br.com.venzel.store.modules.user.mappers.UserMapper;
import br.com.venzel.store.modules.user.providers.hash_provider.HashProvider;
import br.com.venzel.store.modules.user.repositories.UserRepository;
import br.com.venzel.store.modules.user.utils.UserMessageUtils;

@Service
public class CreateUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Qualifier("mockHashProvider")
    @Autowired
    private HashProvider hashProvider;

    @Transactional
    public UserDTO execute(CreateUserDTO dto) {
        
        Boolean userAlreadyExistsWithEmail = userRepository.existsByEmail(dto.getEmail());

        if (userAlreadyExistsWithEmail) {
            throw new UserAlreadyExistsException(UserMessageUtils.USER_ALREADY_EXISTS);
        }

        User user = userMapper.toEntity(dto);

        user.setPassword(hashProvider.generateHash(dto.getPassword()));

        userRepository.save(user);

        return userMapper.toDTO(user);
    }
}
