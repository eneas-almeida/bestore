package br.com.venzel.store.modules.order.use_cases.create_order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.venzel.store.modules.order.dtos.order.CreateOrderDTO;
import br.com.venzel.store.modules.order.dtos.order.OrderDTO;

@RestController
@RequestMapping("/orders")
public class CreateOrderController {

    @Autowired
    private CreateOrderService createOrderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO handle(@RequestBody CreateOrderDTO dto) {

        return createOrderService.execute(dto);
    }
}
