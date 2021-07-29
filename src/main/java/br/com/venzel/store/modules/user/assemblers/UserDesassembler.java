package br.com.venzel.store.modules.user.assemblers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.venzel.store.modules.user.entities.User;

@Component
public class UserDesassembler {

    @Autowired
    private ModelMapper modelMapper;

    public User toDomain(Object dto) {
        return modelMapper.map(dto, User.class);
    }

    public void toCopyDomain(Object dto, User user) {
        modelMapper.map(dto, user);
    }
}
