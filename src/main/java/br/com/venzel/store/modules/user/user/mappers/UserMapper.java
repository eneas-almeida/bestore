package br.com.venzel.store.modules.user.user.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.venzel.store.modules.user.user.dtos.CreateUserDTO;
import br.com.venzel.store.modules.user.user.dtos.UpdateUserDTO;
import br.com.venzel.store.modules.user.user.dtos.UserDTO;
import br.com.venzel.store.modules.user.user.entities.User;

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

    public Page<UserDTO> toCollectionPageModel(Page<User> users) {
        return users.map(e -> toDTO(e));
    }

    public User toEntity(CreateUserDTO dto) {
        return modelMapper.map(dto, User.class);
    }

    public void toCopyEntity(UpdateUserDTO dto, User user) {
        modelMapper.map(dto, user);
    }
}
