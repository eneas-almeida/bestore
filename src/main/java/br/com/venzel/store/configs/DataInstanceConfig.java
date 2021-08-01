package br.com.venzel.store.configs;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.venzel.store.modules.address.entities.Address;
import br.com.venzel.store.modules.address.entities.City;
import br.com.venzel.store.modules.address.entities.State;
import br.com.venzel.store.modules.address.repositories.AddressRepository;
import br.com.venzel.store.modules.address.repositories.CityRepository;
import br.com.venzel.store.modules.address.repositories.StateRepository;
import br.com.venzel.store.modules.order.entities.Order;
import br.com.venzel.store.modules.order.repositories.OrderRepository;
import br.com.venzel.store.modules.payment.entities.Payment;
import br.com.venzel.store.modules.payment.repositories.PaymentRepository;
import br.com.venzel.store.modules.product.entities.Category;
import br.com.venzel.store.modules.product.entities.Product;
import br.com.venzel.store.modules.product.repositories.CategoryRepository;
import br.com.venzel.store.modules.product.repositories.ProductRepository;
import br.com.venzel.store.modules.user.entities.User;
import br.com.venzel.store.modules.user.entities.types.UserType;
import br.com.venzel.store.modules.user.providers.hash_provider.HashProvider;
import br.com.venzel.store.modules.user.repositories.UserRepository;

@Configuration
public class DataInstanceConfig implements CommandLineRunner {
    
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Qualifier("mockHashProvider")
    @Autowired
    private HashProvider hashProvider;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private StateRepository stateRepository;
    
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void run(String... args) throws Exception {
        
        /* */

        Category ca1 = new Category("cereais");
        Category ca2 = new Category("padaria");
        Category ca3 = new Category("mercearia");

        Product pd1 = new Product("feijao", 10.21);
        Product pd2 = new Product("arroz", 7.44);
        Product pd3 = new Product("cuzcuz", 3.76);

        User us1 = new User("Tiago Rizzo", "tiago@gmail.com", hashProvider.generateHash("tiago"), UserType.LEGAL_PERSON);
        User us2 = new User("Alex Moura", "alex@gmail.com", hashProvider.generateHash("alex"), UserType.PHYSICAL_PERSON);
        User us3 = new User("Liz Venzel", "liz@gmail.com", hashProvider.generateHash("liz"), UserType.LEGAL_PERSON);

        Order od1 = new Order();
        Order od2 = new Order();
        Order od3 = new Order();

        Payment pm1 = new Payment("SEPARACAO");
        Payment pm2 = new Payment("SEPARACAO");
        Payment pm3 = new Payment("SEPARACAO");

        State st1 = new State("SP");
        State st2 = new State("RJ");
        State st3 = new State("PE");
        State st4 = new State("PB");

        City ct1 = new City("Bauru", st1);
        City ct2 = new City("Campinas", st1);
        City ct3 = new City("Macae", st2);
        City ct4 = new City("Recife", st3);
        City ct5 = new City("Campina Grande", st4);

        Address ad1 = new Address("Rua 13 de maio", "213", null, null, "58429077", us1, ct1);
        Address ad2 = new Address("Rua Pedro II", "34", null, null, "58429077", us2, ct2);
        Address ad3 = new Address("Rua Afonso Campos", "90", null, null, "58429077", us3, ct3);
        Address ad4 = new Address("Avenida Santa Cruz", "102", null, null, "58429077", us3, ct4);

        /* */

        us1.getAdresses().addAll(Arrays.asList(ad1, ad2));
        us2.getAdresses().addAll(Arrays.asList(ad3));
        us3.getAdresses().addAll(Arrays.asList(ad4));

        /* */

        us1.getTelephones().addAll(Arrays.asList("3332020", "89122311", "32001222"));
        us2.getTelephones().addAll(Arrays.asList("3012123", "44122314", "72315522"));
        us3.getTelephones().addAll(Arrays.asList("6323442", "32454423", "43334768"));

        /* */

        ca1.getProducts().addAll(Arrays.asList(pd1, pd2, pd3));
        ca2.getProducts().addAll(Arrays.asList(pd2));

        /* */

        pd1.getCategories().addAll(Arrays.asList(ca1));
        pd2.getCategories().addAll(Arrays.asList(ca1, ca2));
        pd3.getCategories().addAll(Arrays.asList(ca1));

        /* */

        st1.getCities().addAll(Arrays.asList(ct1, ct2));
        st2.getCities().addAll(Arrays.asList(ct3));
        st3.getCities().addAll(Arrays.asList(ct4));
        st4.getCities().addAll(Arrays.asList(ct5));

        /* */

        categoryRepository.saveAll(Arrays.asList(ca1, ca2, ca3));
        productRepository.saveAll(Arrays.asList(pd1, pd2, pd3));
        userRepository.saveAll(Arrays.asList(us1, us2, us3));
        orderRepository.saveAll(Arrays.asList(od1, od2, od3));
        paymentRepository.saveAll(Arrays.asList(pm1, pm2, pm3));
        stateRepository.saveAll(Arrays.asList(st1, st2, st3, st4));
        cityRepository.saveAll(Arrays.asList(ct1, ct2, ct3, ct4, ct5));
        addressRepository.saveAll(Arrays.asList(ad1, ad2, ad3, ad4));
    }
}
