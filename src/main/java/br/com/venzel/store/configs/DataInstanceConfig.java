package br.com.venzel.store.configs;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.venzel.store.modules.order.entities.Order;
import br.com.venzel.store.modules.order.repositories.OrderRepository;
import br.com.venzel.store.modules.product.entities.Category;
import br.com.venzel.store.modules.product.entities.Product;
import br.com.venzel.store.modules.product.repositories.CategoryRepository;
import br.com.venzel.store.modules.product.repositories.ProductRepository;
import br.com.venzel.store.modules.user.entities.User;
import br.com.venzel.store.modules.user.repositories.UserRepository;

@Configuration
public class DataInstanceConfig implements CommandLineRunner {
    
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        
        /* */

        Category c1 = new Category("cereais");
        Category c2 = new Category("padaria");

        Product p1 = new Product("feijao", 10.21);
        Product p2 = new Product("arroz", 7.44);
        Product p3 = new Product("cuzcuz", 3.76);

        User u1 = new User("Tiago Rizzo", "tiago@gmail.com", "boladegudi");
        User u2 = new User("Alex Moura", "alex@gmail.com", "cotonetepodre");
        User u3 = new User("Liz Venzel", "liz@gmail.com", "gaioladepassaro");

        Order o1 = new Order();
        Order o2 = new Order();
        Order o3 = new Order();

        /* */

        c1.getProducts().addAll(Arrays.asList(p1, p2, p3));
        c2.getProducts().addAll(Arrays.asList(p2));

        /* */

        p1.getCategories().addAll(Arrays.asList(c1));
        p2.getCategories().addAll(Arrays.asList(c1, c2));
        p3.getCategories().addAll(Arrays.asList(c1));

        /* */

        categoryRepository.saveAll(Arrays.asList(c1, c2));
        productRepository.saveAll(Arrays.asList(p1, p2, p3));
        userRepository.saveAll(Arrays.asList(u1, u2, u3));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
