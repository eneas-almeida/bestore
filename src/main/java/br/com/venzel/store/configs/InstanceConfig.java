package br.com.venzel.store.configs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.venzel.store.modules.product.entities.Product;
import br.com.venzel.store.modules.product.repositories.ProductRepository;
import br.com.venzel.store.modules.user.entities.User;
import br.com.venzel.store.modules.user.repositories.UserRepository;

@Configuration
public class InstanceConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        
        /* User */

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

         /* User */

         productRepository.deleteAll();

         Product feijao = Product.builder()
                         .name("feijao")
                         .price(10.21)
                         .activated(true)
                         .build();

        Product arroz = Product.builder()
                         .name("arroz")
                         .price(7.42)
                         .activated(true)
                         .build();

        Product cuzcuz = Product.builder()
                         .name("cuzcuz")
                         .price(3.39)
                         .activated(true)
                         .build();

        List<Product> products = new ArrayList<>();

        products.addAll(Arrays.asList(feijao, arroz, cuzcuz));

        productRepository.saveAll(products);
    }
}
