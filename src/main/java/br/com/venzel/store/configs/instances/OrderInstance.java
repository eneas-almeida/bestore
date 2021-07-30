package br.com.venzel.store.configs.instances;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.venzel.store.modules.order.entities.Order;
import br.com.venzel.store.modules.order.repositories.OrderRepository;

@Service
public class OrderInstance {

    @Autowired
    private OrderRepository orderRepository;

    public void populate() {

        orderRepository.deleteAll();

        orderRepository.saveAll(getList());
    }

    public List<Order> getList() {

        Order order_tiago = entityBuilder();
        Order order_alex = entityBuilder();
        Order order_liz = entityBuilder();

        List<Order> Orders = new ArrayList<>();

        Orders.addAll(Arrays.asList(order_tiago, order_alex, order_liz));

        return Orders;
    }

    public Order entityBuilder() {

        return Order.builder()
                    .activated(true)
                    .build();
    }
}
