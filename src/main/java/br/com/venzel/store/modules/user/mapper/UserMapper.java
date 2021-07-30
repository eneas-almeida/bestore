package br.com.venzel.store.modules.user.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.venzel.store.modules.user.dtos.UserDTO;
import br.com.venzel.store.modules.user.entities.User;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO toDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public List<UserDTO> toCollectionModel(List<User> users) {
        return users.stream()
                    .map(e -> toDTO(e))
                    .collect(Collectors.toList());
    }

    public User toEntity(UserDTO dto) {
        return modelMapper.map(dto, User.class);
    }

    public void toCopyEntity(UserDTO dto, User user) {
        modelMapper.map(dto, user);
    }
}
