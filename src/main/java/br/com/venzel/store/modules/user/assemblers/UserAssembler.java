package br.com.venzel.store.modules.user.assemblers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.venzel.store.modules.user.dtos.UserDTO;
import br.com.venzel.store.modules.user.entities.User;

@Component
public class UserAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO toModel(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public List<UserDTO> toListModel(List<User> list) {
        return list.stream()
                    .map(e -> toModel(e))
                    .collect(Collectors.toList());
    }
}
