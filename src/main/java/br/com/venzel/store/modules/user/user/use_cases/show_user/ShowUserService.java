package br.com.venzel.store.modules.user.user.use_cases.show_user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.user.user.dtos.UserDTO;
import br.com.venzel.store.modules.user.user.entities.User;
import br.com.venzel.store.modules.user.user.exceptions.UserNotFoundException;
import br.com.venzel.store.modules.user.user.mappers.UserMapper;
import br.com.venzel.store.modules.user.user.repositories.UserRepository;
import br.com.venzel.store.modules.user.user.utils.UserMessageUtils;

@Service
public class ShowUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public UserDTO execute(Long id) {
        
        Optional<User> optionalEntity = userRepository.findById(id);

        if (!optionalEntity.isPresent()) {
            throw new UserNotFoundException(UserMessageUtils.USER_NOT_FOUND);
        }

        return userMapper.toDTO(optionalEntity.get());
    }
}
