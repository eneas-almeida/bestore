package br.com.venzel.store.configs.instances;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.venzel.store.modules.payment.entities.Payment;
import br.com.venzel.store.modules.payment.repositories.PaymentRepository;

@Service
public class PaymentInstance {

    @Autowired
    private PaymentRepository paymentRepository;

    public void populate() {

        paymentRepository.deleteAll();

        paymentRepository.saveAll(getList());
    }

    public List<Payment> getList() {

        Payment picpay = entityBuilder("picpay", "SEPARATE PRODUCT");
        Payment paypal = entityBuilder("paypal", "SEPARATE PRODUCT");
        Payment pagarme = entityBuilder("pagarme", "SEPARATE PRODUCT");

        List<Payment> payments = new ArrayList<>();

        payments.addAll(Arrays.asList(picpay, paypal, pagarme));

        return payments;
    }

    public Payment entityBuilder(String name, String state) {

        return Payment.builder()
                        .name(name)
                        .state(state)
                        .build();
    }
}
