package br.com.venzel.store.modules.order.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.venzel.store.modules.order.dtos.OrderDTO;
import br.com.venzel.store.modules.order.entities.Order;

@Component
public class OrderMapper {

    @Autowired
    private ModelMapper modelMapper;

    public OrderDTO toDTO(Order order) {
        return modelMapper.map(order, OrderDTO.class);
    }

    public List<OrderDTO> toCollectionModel(List<Order> orders) {
        return orders.stream()
                    .map(e -> toDTO(e))
                    .collect(Collectors.toList());
    }

    public Order toEntity(OrderDTO dto) {
        return modelMapper.map(dto, Order.class);
    }

    public void toCopyEntity(OrderDTO dto, Order order) {
        modelMapper.map(dto, order);
    }
}
