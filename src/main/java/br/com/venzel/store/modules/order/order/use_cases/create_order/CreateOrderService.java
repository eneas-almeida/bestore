package br.com.venzel.store.modules.order.order.use_cases.create_order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.order.order.dtos.CreateOrderDTO;
import br.com.venzel.store.modules.order.order.dtos.OrderDTO;
import br.com.venzel.store.modules.order.order.entities.Order;
import br.com.venzel.store.modules.order.order.mappers.OrderMapper;
import br.com.venzel.store.modules.order.order.repositories.OrderRepository;

@Service
public class CreateOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Transactional
    public OrderDTO execute(CreateOrderDTO dto) {
        
        Order order = orderMapper.toEntity(dto);

        orderRepository.save(order);

        return orderMapper.toDTO(order);
    }
}
