package br.com.venzel.store.modules.user.user.use_cases.list_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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
public class ListUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;
    
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Page<UserDTO> execute(Integer page, Integer linesPerPage, String orderBy, String direction) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

        Page<User> users = userRepository.findAll(pageRequest);

        if (users.isEmpty()) {
            throw new UserNotFoundException(UserMessageUtils.USER_NOT_FOUND);
        }

        Page<UserDTO> pageUserDTO = userMapper.toCollectionPageModel(users);

        return pageUserDTO;
    }
}
