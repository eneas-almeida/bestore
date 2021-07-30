package br.com.venzel.store.configs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.venzel.store.modules.user.entities.User;
import br.com.venzel.store.modules.user.repositories.UserRepository;

@Configuration
public class InstanceConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        
        userRepository.deleteAll();

        User tiago = User.builder()
                        .name("tiago")
                        .email("tiago@gmail.com")
                        .password("ovopreto")
                        .build();
        
        User alex = User.builder()
                        .name("alex")
                        .email("alex@gmail.com")
                        .password("ovobranco")
                        .build();

        User liz = User.builder()
                        .name("liz")
                        .email("liz@gmail.com")
                        .password("ovoverde")
                        .build();

        List<User> users = new ArrayList<>();

        users.addAll(Arrays.asList(tiago, alex, liz));

        userRepository.saveAll(users);
    }
}
