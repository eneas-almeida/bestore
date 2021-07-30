package br.com.venzel.store.modules.user.use_cases.delete_user;

import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.user.dtos.UserDTO;
import br.com.venzel.store.modules.user.entities.User;
import br.com.venzel.store.modules.user.exceptions.UserNotFoundException;
import br.com.venzel.store.modules.user.mapper.UserMapper;
import br.com.venzel.store.modules.user.repositories.UserRepository;
import br.com.venzel.store.modules.user.utils.UserMessageUtils;

@Service
public class DeleteUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public UserDTO execute(Long id) {
        
        Optional<User> optionalEntity = userRepository.findById(id);

        if (!optionalEntity.isPresent()) {
            throw new UserNotFoundException(UserMessageUtils.USER_NOT_FOUND);
        }

        User user = optionalEntity.get();

        /* 

        userRepository.deleteById(id);

        userRepository.flush();
        
        */

        /* Update data */

        user.setDeletedAt(OffsetDateTime.now(Clock.systemUTC()));

        user.inactive();

        user.disallow();

        /* End update data */

        return userMapper.toDTO(user);
    }
}
