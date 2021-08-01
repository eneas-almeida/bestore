package br.com.venzel.store.modules.user.use_cases.user.list_user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.user.dtos.user.UserDTO;
import br.com.venzel.store.modules.user.entities.User;
import br.com.venzel.store.modules.user.exceptions.user.UserNotFoundException;
import br.com.venzel.store.modules.user.mappers.UserMapper;
import br.com.venzel.store.modules.user.repositories.UserRepository;
import br.com.venzel.store.modules.user.utils.UserMessageUtils;

@Service
public class ListUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;
    
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<UserDTO> execute() {

        List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            throw new UserNotFoundException(UserMessageUtils.USER_NOT_FOUND);
        }

        return userMapper.toCollectionModel(users);
    }
}
