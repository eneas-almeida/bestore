package br.com.venzel.store.configs.instances;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.venzel.store.configs.AmbientConfig;

@Configuration
public class InstanceConfig implements CommandLineRunner {

    @Autowired
    private AmbientConfig ambientConfig;

    @Autowired
    private UserInsntace userInsntace;

    @Autowired
    private ProductInstance productInstance;

    @Autowired
    private CategoryInstance categoryInstance;

    @Autowired
    private PaymentInstance paymentInstance;

    @Autowired
    private OrderInstance orderInstance;

    @Override
    public void run(String... args) throws Exception {

        if (ambientConfig.getActive().equals("development")) {

            userInsntace.populate();
            productInstance.populate();
            categoryInstance.populate();
            paymentInstance.populate();
            orderInstance.populate();
        }
    }
}
