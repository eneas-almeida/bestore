package br.com.venzel.store.modules.order.use_cases.delete_order;

import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.order.dtos.OrderDTO;
import br.com.venzel.store.modules.order.entities.Order;
import br.com.venzel.store.modules.order.exceptions.OrderNotFoundException;
import br.com.venzel.store.modules.order.mappers.OrderMapper;
import br.com.venzel.store.modules.order.repositories.OrderRepository;
import br.com.venzel.store.modules.order.utils.OrderMessageUtils;

@Service
public class DeleteOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Transactional
    public OrderDTO execute(Long id) {
        
        Optional<Order> optionalEntity = orderRepository.findById(id);

        if (!optionalEntity.isPresent()) {
            throw new OrderNotFoundException(OrderMessageUtils.ORDER_NOT_FOUND);
        }

        Order order = optionalEntity.get();

        /* Update data */

        order.setDeletedAt(OffsetDateTime.now(Clock.systemUTC()));

        order.inactive();

        /* End update data */

        return orderMapper.toDTO(order);
    }
}
