package br.com.venzel.store.modules.order.use_cases.update_order;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.order.dtos.OrderDTO;
import br.com.venzel.store.modules.order.dtos.UpdateOrderDTO;
import br.com.venzel.store.modules.order.entities.Order;
import br.com.venzel.store.modules.order.exceptions.OrderNotFoundException;
import br.com.venzel.store.modules.order.mapper.OrderMapper;
import br.com.venzel.store.modules.order.repositories.OrderRepository;
import br.com.venzel.store.modules.order.utils.OrderMessageUtils;

@Service
public class UpdateOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Transactional
    public OrderDTO execute(UpdateOrderDTO dto, Long id) {

        Optional<Order> optionalEntity = orderRepository.findById(id);

        if (!optionalEntity.isPresent()) {
            throw new OrderNotFoundException(OrderMessageUtils.ORDER_NOT_FOUND);
        }

        Order order = optionalEntity.get();

        orderMapper.toCopyEntity(dto, order);        

        return orderMapper.toDTO(order);
    }
}
