package br.com.venzel.store.configs;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.venzel.store.modules.order.entities.Order;
import br.com.venzel.store.modules.order.entities.OrderItem;
import br.com.venzel.store.modules.order.repositories.OrderItemRepository;
import br.com.venzel.store.modules.order.repositories.OrderRepository;
import br.com.venzel.store.modules.payment.entities.Payment;
import br.com.venzel.store.modules.payment.entities.PaymentCard;
import br.com.venzel.store.modules.payment.entities.types.PaymentState;
import br.com.venzel.store.modules.payment.repositories.PaymentRepository;
import br.com.venzel.store.modules.product.entities.Category;
import br.com.venzel.store.modules.product.entities.Product;
import br.com.venzel.store.modules.product.repositories.CategoryRepository;
import br.com.venzel.store.modules.product.repositories.ProductRepository;
import br.com.venzel.store.modules.user.entities.Address;
import br.com.venzel.store.modules.user.entities.City;
import br.com.venzel.store.modules.user.entities.State;
import br.com.venzel.store.modules.user.entities.User;
import br.com.venzel.store.modules.user.entities.types.UserType;
import br.com.venzel.store.modules.user.providers.hash_provider.HashProvider;
import br.com.venzel.store.modules.user.repositories.AddressRepository;
import br.com.venzel.store.modules.user.repositories.CityRepository;
import br.com.venzel.store.modules.user.repositories.StateRepository;
import br.com.venzel.store.modules.user.repositories.UserRepository;

@Configuration
public class DataInstanceConfig implements CommandLineRunner {

    /* Repositories injecteds */
    
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

    @Autowired
    private OrderItemRepository orderItemRepository;

    /* Auto execute method */

    @Override
    public void run(String... args) throws Exception {
        
        /* Category */

        Category ct1 = new Category("cereais");
        Category ct2 = new Category("padaria");
        Category ct3 = new Category("mercearia");

        /* Product */

        Product pt1 = new Product("feijao", 10.21);
        Product pt2 = new Product("arroz", 7.44);
        Product pt3 = new Product("cuzcuz", 3.76);

        /* User */

        User us1 = new User("Tiago Rizzo", "tiago@gmail.com", hashProvider.generateHash("tiago"), UserType.LEGAL_PERSON);
        User us2 = new User("Alex Moura", "alex@gmail.com", hashProvider.generateHash("alex"), UserType.PHYSICAL_PERSON);
        User us3 = new User("Liz Venzel", "liz@gmail.com", hashProvider.generateHash("liz"), UserType.LEGAL_PERSON);

        /* Order */

        Order or1 = new Order(us1);
        Order or2 = new Order(us2);
        Order or3 = new Order(us3);

        /* Payment */

        Payment pg1 = new PaymentCard(300.21, PaymentState.PENDING, or1, 3);
        or1.setPayment(pg1);

        Payment pg2 = new PaymentCard(402.28, PaymentState.PENDING, or2, 6);
        or2.setPayment(pg2);

        Payment pg3 = new PaymentCard(529.44, PaymentState.PENDING, or3, 12);
        or3.setPayment(pg3);

        us1.getOrders().addAll(Arrays.asList(or1, or2));

        /* State */

        State st1 = new State("SP");
        State st2 = new State("RJ");
        State st3 = new State("PE");
        State st4 = new State("PB");

        /* City */

        City cy1 = new City("Bauru", st1);
        City cy2 = new City("Campinas", st1);
        City cy3 = new City("Macae", st2);
        City cy4 = new City("Recife", st3);
        City cy5 = new City("Campina Grande", st4);

        /* Address */

        Address ad1 = new Address("Rua 13 de maio", "213", null, null, "58429077", us1, cy1);
        Address ad2 = new Address("Rua Pedro II", "34", null, null, "58429077", us2, cy2);
        Address ad3 = new Address("Rua Afonso Campos", "90", null, null, "58429077", us1, cy3);
        Address ad4 = new Address("Avenida Santa Cruz", "102", null, null, "58429077", us3, cy4);
        Address ad5 = new Address("Avenida Santa Cruz", "102", null, null, "58429077", us1, cy4);

        /* OrdeItem */

        OrderItem oi1 = new OrderItem(or1, pt1, 0.00, 1, 197.03);
        OrderItem oi2 = new OrderItem(or1, pt3, 0.00, 2, 336.28);
        OrderItem oi3 = new OrderItem(or2, pt2, 10.00, 1, 421.28);

        or1.getItens().addAll(Arrays.asList(oi1, oi2));
        or2.getItens().addAll(Arrays.asList(oi3));

        pt1.getItens().addAll(Arrays.asList(oi1));
        pt2.getItens().addAll(Arrays.asList(oi3));
        pt3.getItens().addAll(Arrays.asList(oi2));

        /* User : Add all address */

        us1.getAdresses().addAll(Arrays.asList(ad1, ad2));
        us2.getAdresses().addAll(Arrays.asList(ad3));
        us3.getAdresses().addAll(Arrays.asList(ad4));
        us3.getAdresses().addAll(Arrays.asList(ad5));

        /* User : Add all telephones */

        us1.getTelephones().addAll(Arrays.asList("3332020", "89122311", "32001222"));
        us2.getTelephones().addAll(Arrays.asList("3012123", "44122314", "72315522"));
        us3.getTelephones().addAll(Arrays.asList("6323442", "32454423", "43334768"));

        /* Category : Add all products */

        ct1.getProducts().addAll(Arrays.asList(pt1, pt2, pt3));
        ct2.getProducts().addAll(Arrays.asList(pt2));

        /* */

        pt1.getCategories().addAll(Arrays.asList(ct1));
        pt2.getCategories().addAll(Arrays.asList(ct1, ct2));
        pt3.getCategories().addAll(Arrays.asList(ct1));

        /* Product : Add all categories */

        st1.getCities().addAll(Arrays.asList(cy1, cy2));
        st2.getCities().addAll(Arrays.asList(cy3));
        st3.getCities().addAll(Arrays.asList(cy4));
        st4.getCities().addAll(Arrays.asList(cy5));

        /* Repositories : Add all */

        categoryRepository.saveAll(Arrays.asList(ct1, ct2, ct3));
        productRepository.saveAll(Arrays.asList(pt1, pt2, pt3));
        userRepository.saveAll(Arrays.asList(us1, us2, us3));
        stateRepository.saveAll(Arrays.asList(st1, st2, st3, st4));
        cityRepository.saveAll(Arrays.asList(cy1, cy2, cy3, cy4, cy5));
        addressRepository.saveAll(Arrays.asList(ad1, ad2, ad3, ad4, ad5));
        orderRepository.saveAll(Arrays.asList(or1, or2, or3));
        paymentRepository.saveAll(Arrays.asList(pg1, pg2, pg3));
        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3));
    }
}
