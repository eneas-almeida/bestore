package br.com.venzel.store.modules.order.order.use_cases.list_order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.order.order.dtos.OrderDTO;
import br.com.venzel.store.modules.order.order.entities.Order;
import br.com.venzel.store.modules.order.order.exceptions.OrderNotFoundException;
import br.com.venzel.store.modules.order.order.mappers.OrderMapper;
import br.com.venzel.store.modules.order.order.repositories.OrderRepository;
import br.com.venzel.store.modules.order.order.utils.OrderMessageUtils;

@Service
public class ListOrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;
    
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Page<OrderDTO> execute(Integer page, Integer linesPerPage, String orderBy, String direction) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

        Page<Order> orders = orderRepository.findAll(pageRequest);

        if (orders.isEmpty()) {
            throw new OrderNotFoundException(OrderMessageUtils.ORDER_NOT_FOUND);
        }

        Page<OrderDTO> pageOrderDTO = orderMapper.toCollectionPageModel(orders);

        return pageOrderDTO;
    }
}
