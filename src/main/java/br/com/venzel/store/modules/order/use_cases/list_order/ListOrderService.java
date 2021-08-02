package br.com.venzel.store.modules.order.use_cases.list_order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.order.dtos.order.OrderDTO;
import br.com.venzel.store.modules.order.entities.Order;
import br.com.venzel.store.modules.order.exceptions.OrderNotFoundException;
import br.com.venzel.store.modules.order.mappers.OrderMapper;
import br.com.venzel.store.modules.order.repositories.OrderRepository;
import br.com.venzel.store.modules.order.utils.OrderMessageUtils;

@Service
public class ListOrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;
    
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<OrderDTO> execute() {

        List<Order> orders = orderRepository.findAll();

        if (orders.isEmpty()) {
            throw new OrderNotFoundException(OrderMessageUtils.ORDER_NOT_FOUND);
        }

        return orderMapper.toCollectionModel(orders);
    }
}
