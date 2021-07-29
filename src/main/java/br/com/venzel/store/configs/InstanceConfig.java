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

        User tiago = new User(null, "Tiago", "tiago@gmail.com", "queijo");
        User alex = new User(null, "Alex", "alex@gmail.com", "queijo");
        User liz = new User(null, "Liz", "liz@gmail.com", "queijo");

        List<User> users = new ArrayList<>();

        users.addAll(Arrays.asList(tiago, alex, liz));

        userRepository.saveAll(users);
    }
}
