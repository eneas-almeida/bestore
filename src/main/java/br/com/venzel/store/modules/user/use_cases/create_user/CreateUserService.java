package br.com.venzel.store.modules.user.use_cases.create_user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.user.dtos.UserDTO;
import br.com.venzel.store.modules.user.entities.User;
import br.com.venzel.store.modules.user.exceptions.UserAlreadyExistsException;
import br.com.venzel.store.modules.user.mapper.UserMapper;
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
    public UserDTO execute(UserDTO dto) {
        
        Optional<User> optionalEntity = userRepository.findOneByEmail(dto.getEmail());

        if (optionalEntity.isPresent()) {
            throw new UserAlreadyExistsException(UserMessageUtils.USER_ALREADY_EXISTS);
        }

        User user = userMapper.toEntity(dto);

        /* Update data */

        user.inactive();

        user.disallow();

        /* End update data */

        user.setPassword(hashProvider.generateHash(dto.getPassword()));

        userRepository.save(user);

        return userMapper.toDTO(user);
    }
}
