package br.com.venzel.store.modules.user.user.use_cases.create_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.user.user.dtos.CreateUserDTO;
import br.com.venzel.store.modules.user.user.dtos.UserDTO;
import br.com.venzel.store.modules.user.user.entities.User;
import br.com.venzel.store.modules.user.user.entities.types.UserType;
import br.com.venzel.store.modules.user.user.exceptions.UserAlreadyExistsException;
import br.com.venzel.store.modules.user.user.mappers.UserMapper;
import br.com.venzel.store.modules.user.user.providers.hash_provider.HashProvider;
import br.com.venzel.store.modules.user.user.repositories.UserRepository;
import br.com.venzel.store.modules.user.user.utils.UserMessageUtils;

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

        /* Verify user existence with email */

        Boolean existsUser = userRepository.existsByEmail(dto.getEmail());

        if (existsUser) {
            throw new UserAlreadyExistsException(UserMessageUtils.USER_ALREADY_EXISTS);
        }

        /* Parse dto to entity */
        
        User user = userMapper.toEntity(dto);

        /* Set type user default */

        user.setType(UserType.PHYSICAL_PERSON);

        /* Set allow user default */

        user.allow();

        /* Set inactive user default */

        user.inactive();
        
        /* Generate password hash */
        
        user.setPassword(hashProvider.generateHash(dto.getPassword()));
        
        /* Save user in repository */
        
        userRepository.save(user);

        /* Parse entity to dto and return */

        return userMapper.toDTO(user);
    }
}
