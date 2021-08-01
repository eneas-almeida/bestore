package br.com.venzel.store.modules.user.use_cases.user.update_user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.user.dtos.user.UpdateUserDTO;
import br.com.venzel.store.modules.user.dtos.user.UserDTO;
import br.com.venzel.store.modules.user.entities.User;
import br.com.venzel.store.modules.user.exceptions.user.UserNotFoundException;
import br.com.venzel.store.modules.user.mappers.UserMapper;
import br.com.venzel.store.modules.user.repositories.UserRepository;
import br.com.venzel.store.modules.user.utils.UserMessageUtils;

@Service
public class UpdateUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public UserDTO execute(UpdateUserDTO dto, Long id) {

        Optional<User> optionalEntity = userRepository.findById(id);

        if (!optionalEntity.isPresent()) {
            throw new UserNotFoundException(UserMessageUtils.USER_NOT_FOUND);
        }

        User user = optionalEntity.get();

        userMapper.toCopyEntity(dto, user);

        return userMapper.toDTO(user);
    }
}
