package br.com.venzel.store.modules.user.user.use_cases.create_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.activity.activity.use_cases.create_cctivity.CreateActivityService;
import br.com.venzel.store.modules.user.user.dtos.CreateUserDTO;
import br.com.venzel.store.modules.user.user.dtos.UserDTO;
import br.com.venzel.store.modules.user.user.entities.User;
import br.com.venzel.store.modules.user.user.entities.types.UserState;
import br.com.venzel.store.modules.user.user.exceptions.UserAlreadyExistsException;
import br.com.venzel.store.modules.user.user.mappers.UserMapper;
import br.com.venzel.store.modules.user.user.providers.hash_provider.HashProvider;
import br.com.venzel.store.modules.user.user.repositories.UserRepository;
import br.com.venzel.store.modules.user.user.utils.UserMessageUtils;
import br.com.venzel.store.shared.providers.mail_provider.MailProvider;

@Service
public class CreateUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CreateActivityService createActivityService;

    @Qualifier("mockHashProvider")
    @Autowired
    private HashProvider hashProvider;

    @Autowired
    private MailProvider mailProvider;

    @Transactional
    public UserDTO execute(CreateUserDTO dto) {

        /* Verify user existence with email */

        Boolean existsUser = userRepository.existsByEmail(dto.getEmail());

        if (existsUser) {
            throw new UserAlreadyExistsException(UserMessageUtils.USER_ALREADY_EXISTS);
        }

        /* Parse dto to entity */
        
        User user = userMapper.toEntity(dto);

        /* Set state default */

        user.setState(UserState.NEW);
        
        /* Generate password hash */
        
        user.setPassword(hashProvider.generateHash(dto.getPassword()));
        
        /* Save user in repository */
        
        userRepository.save(user);

        /* Create activity */

        createActivityService.execute(UserMessageUtils.USER_REGISTRED, user);

        /* Send mail confirmation */

        mailProvider.sendUserConfirmationMail(user);

        /* Parse entity to dto and return */

        return userMapper.toDTO(user);
    }
}
