package br.com.venzel.store.modules.user.use_cases.update_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.user.dtos.UserDTO;
import br.com.venzel.store.modules.user.entities.User;
import br.com.venzel.store.modules.user.mapper.UserMapper;
import br.com.venzel.store.modules.user.repositories.UserRepository;

@Service
public class UpdateUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public UserDTO execute(UserDTO dto, Long id) {

        User user = userMapper.toEntity(dto);

        userRepository.save(user);

        return userMapper.toDTO(user);
    }
}
