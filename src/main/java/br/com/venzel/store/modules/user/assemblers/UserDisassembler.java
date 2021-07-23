package br.com.venzel.store.modules.user.assemblers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.venzel.store.modules.user.dtos.UserInputDTO;
import br.com.venzel.store.modules.user.entities.User;

@Component
public class UserDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public User toObject(UserInputDTO userInputDTO) {
        return modelMapper.map(userInputDTO, User.class);
    }

    public void toCopyObject(UserInputDTO userInputDTO, User user) {
        modelMapper.map(userInputDTO, user);
    }
}
