package br.com.venzel.store.modules.order.use_cases.update_order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.order.dtos.OrderDTO;
import br.com.venzel.store.modules.order.entities.Order;
import br.com.venzel.store.modules.order.mapper.OrderMapper;
import br.com.venzel.store.modules.order.repositories.OrderRepository;

@Service
public class UpdateOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Transactional
    public OrderDTO execute(OrderDTO dto, Long id) {

        Order order = orderMapper.toEntity(dto);

        orderRepository.save(order);

        return orderMapper.toDTO(order);
    }
}
