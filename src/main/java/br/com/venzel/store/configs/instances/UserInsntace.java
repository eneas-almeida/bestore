package br.com.venzel.store.configs.instances;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.venzel.store.modules.user.entities.User;
import br.com.venzel.store.modules.user.repositories.UserRepository;

@Service
public class UserInsntace {

    @Autowired
    private UserRepository userRepository;
    
    public void populate() {

        userRepository.deleteAll();

        userRepository.saveAll(getList());
    }

    private List<User> getList() {

        User tiago = entityBuilder("tiago", "tiago@gmail.com", "fofokacomfada");
        User alex = entityBuilder("tiago", "alex@gmail.com", "fofokacomgnomo");
        User liz = entityBuilder("tiago", "lix@gmail.com", "fofocacomfarinha");

        List<User> users = new ArrayList<>();

        users.addAll(Arrays.asList(tiago, alex, liz));

        return users;
    }

    private User entityBuilder(String name, String email, String password) {

        return User.builder()
                    .name(name)
                    .email(email)
                    .password(password)
                    .build();

    }
}
