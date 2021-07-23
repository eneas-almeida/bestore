package br.com.venzel.store.modules.user.assemblers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.venzel.store.modules.user.dtos.UserInputDTO;
import br.com.venzel.store.modules.user.entities.User;

@Component
public class UserDesassembler {

    @Autowired
    private ModelMapper modelMapper;

    public User toDomain(UserInputDTO userInputDTO) {
        return modelMapper.map(userInputDTO, User.class);
    }

    public void toCopyDomain(UserInputDTO userInputDTO, User user) {
        modelMapper.map(userInputDTO, user);
    }
}
