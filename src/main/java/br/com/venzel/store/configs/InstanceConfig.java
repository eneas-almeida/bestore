package br.com.venzel.store.configs;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.venzel.store.modules.activity.activity.entities.Activity;
import br.com.venzel.store.modules.activity.activity.repositories.ActivityRepository;
import br.com.venzel.store.modules.order.order.entities.Order;
import br.com.venzel.store.modules.order.order.repositories.OrderRepository;
import br.com.venzel.store.modules.order.order_item.entities.OrderItem;
import br.com.venzel.store.modules.order.order_item.repositories.OrderItemRepository;
import br.com.venzel.store.modules.payment.payment.entities.Payment;
import br.com.venzel.store.modules.payment.payment.entities.PaymentCard;
import br.com.venzel.store.modules.payment.payment.entities.PaymentCash;
import br.com.venzel.store.modules.payment.payment.entities.types.PaymentState;
import br.com.venzel.store.modules.payment.payment.repositories.PaymentRepository;
import br.com.venzel.store.modules.product.category.entities.Category;
import br.com.venzel.store.modules.product.category.repositories.CategoryRepository;
import br.com.venzel.store.modules.product.product.entities.Product;
import br.com.venzel.store.modules.product.product.repositories.ProductRepository;
import br.com.venzel.store.modules.profile.address.entities.Address;
import br.com.venzel.store.modules.profile.address.repositories.AddressRepository;
import br.com.venzel.store.modules.profile.profile.entities.Profile;
import br.com.venzel.store.modules.profile.profile.entities.types.ProfileType;
import br.com.venzel.store.modules.profile.profile.repositories.ProfileRepository;
import br.com.venzel.store.modules.user.user.entities.User;
import br.com.venzel.store.modules.user.user.providers.hash_provider.HashProvider;
import br.com.venzel.store.modules.user.user.repositories.UserRepository;

@Configuration
public class InstanceConfig implements CommandLineRunner {

    /* Repositories injecteds */
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Qualifier("mockHashProvider")
    @Autowired
    private HashProvider hashProvider;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;
    
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ActivityRepository activityRepository;

    /* Auto execute method */

    @Override
    public void run(String... args) throws Exception {
        
        /* Category */

        Category ct_1 = new Category("cereais");
        Category ct_2 = new Category("padaria");
        Category ct_3 = new Category("mercearia");
        Category ct_4 = new Category("ferramentas");
        Category ct_5 = new Category("frios");
        Category ct_6 = new Category("jardinagem");
        Category ct_7 = new Category("bebidas");
        Category ct_8 = new Category("limpeza");
        Category ct_9 = new Category("pets");
        Category ct_10 = new Category("grãos");
        Category ct_11 = new Category("beleza");
        Category ct_12 = new Category("frutas");

        /* Product */

        Product pt_1 = new Product("feijao", 10.21);
        Product pt_2 = new Product("arroz", 7.44);
        Product pt_3 = new Product("cuzcuz", 3.76);
        Product pt_4 = new Product("açucar", 7.12);
        Product pt_5 = new Product("manteiga", 12.09);
        Product pt_6 = new Product("trigo", 4.15);
        Product pt_7 = new Product("abacaxi", 1.27);
        Product pt_8 = new Product("laranja", 3.76);
        Product pt_9 = new Product("melão", 2.14);
        Product pt_10 = new Product("fralda", 21.31);

        /* User */

        User us_1 = new User("Tiago Rizzo", "tiago@gmail.com", hashProvider.generateHash("tiago"));
        User us_2 = new User("Alex Moura", "alex@gmail.com", hashProvider.generateHash("alex"));
        User us_3 = new User("Liz Venzel", "liz@gmail.com", hashProvider.generateHash("liz"));

        /* Profile */

        Profile pf_1 = new Profile(us_1, ProfileType.PHYSICAL_PERSON);
        us_1.setProfile(pf_1);

        Profile pf_2 = new Profile(us_2, ProfileType.PHYSICAL_PERSON);
        us_2.setProfile(pf_2);

        Profile pf_3 = new Profile(us_3, ProfileType.PHYSICAL_PERSON);
        us_3.setProfile(pf_2);

        /* Order */

        Order or_1 = new Order(us_1);
        Order or_2 = new Order(us_2);
        Order or_3 = new Order(us_3);

        /* Payment */

        Payment pg_1 = new PaymentCard(PaymentState.PENDING, or_1, 3);
        or_1.setPayment(pg_1);

        Payment pg_2 = new PaymentCash(PaymentState.PENDING, or_2, 300.00);
        or_2.setPayment(pg_2);

        Payment pg_3 = new PaymentCard(PaymentState.PENDING, or_3, 12);
        or_3.setPayment(pg_3);

        us_1.getOrders().addAll(Arrays.asList(or_1, or_2));

        /* Address */

        Address ad_1 = new Address("Rua 13 de maio", "213", null, "Bodcongo", "58429077", "Campina Grande", "PB", pf_1);
        Address ad_2 = new Address("Rua Pedro II", "34", null, "Isabel", "58429077", "Campina Grande", "PB", pf_2);
        Address ad_3 = new Address("Rua Afonso Campos", "90", null, "Nacoes", "58429077", "Macae", "RJ", pf_3);
        Address ad_4 = new Address("Avenida Santa Cruz", "102", null, "Mangabeira", "58429077", "Recife", "PE", pf_1);
        Address ad_5 = new Address("Avenida Santa Cruz", "102", null, "Jose Pinheiro", "58429077", "Macae", "RJ", pf_2);

        /* OrdeItem */

        OrderItem oi_1 = new OrderItem(or_1, pt_1, 0.00, 3, 11.21);
        OrderItem oi_2 = new OrderItem(or_1, pt_3, 0.00, 2, 7.45);
        OrderItem oi_3 = new OrderItem(or_2, pt_2, 10.00, 4, 4.28);

        /* Activity */

        Activity hy_1 = new Activity("Product created, id 1892.", us_1);
        Activity hy_2 = new Activity("User deleted id 012.", us_1);
        Activity hy_3 = new Activity("User deleted id 103", us_2);

        /* */

        or_1.getItens().addAll(Arrays.asList(oi_1, oi_2));
        or_2.getItens().addAll(Arrays.asList(oi_3));

        pt_1.getItens().addAll(Arrays.asList(oi_1));
        pt_2.getItens().addAll(Arrays.asList(oi_3));
        pt_3.getItens().addAll(Arrays.asList(oi_2));

        /* User : Add all address */

        pf_1.getAdresses().addAll(Arrays.asList(ad_1, ad_2));
        pf_2.getAdresses().addAll(Arrays.asList(ad_3));
        pf_3.getAdresses().addAll(Arrays.asList(ad_4));
        pf_3.getAdresses().addAll(Arrays.asList(ad_5));

        /* Category : Add all products */

        ct_1.getProducts().addAll(Arrays.asList(pt_1, pt_2, pt_3));
        ct_2.getProducts().addAll(Arrays.asList(pt_2));
        ct_12.getProducts().addAll(Arrays.asList(pt_7, pt_8, pt_9, pt_10));

        /* Product : Add all categories */

        pt_1.getCategories().addAll(Arrays.asList(ct_1));
        pt_2.getCategories().addAll(Arrays.asList(ct_1, ct_2));
        pt_3.getCategories().addAll(Arrays.asList(ct_1));

        /* Repositories : Add all */

        userRepository.saveAll(Arrays.asList(us_1, us_2, us_3));
        profileRepository.saveAll(Arrays.asList(pf_1, pf_2, pf_3));
        addressRepository.saveAll(Arrays.asList(ad_1, ad_2, ad_3));
        categoryRepository.saveAll(Arrays.asList(ct_1, ct_2, ct_3, ct_4, ct_5, ct_6, ct_7, ct_8, ct_9, ct_10, ct_11, ct_12));
        productRepository.saveAll(Arrays.asList(pt_1, pt_2, pt_3, pt_4, pt_5, pt_6, pt_7, pt_8, pt_9, pt_10));
        orderRepository.saveAll(Arrays.asList(or_1, or_2, or_3));
        paymentRepository.saveAll(Arrays.asList(pg_1, pg_2, pg_3));
        orderItemRepository.saveAll(Arrays.asList(oi_1, oi_2, oi_3));
        activityRepository.saveAll(Arrays.asList(hy_1, hy_2, hy_3));
    }
}
