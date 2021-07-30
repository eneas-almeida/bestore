package br.com.venzel.store.modules.order.use_cases.delete_order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.venzel.store.modules.order.dtos.OrderDTO;

@RestController
@RequestMapping("/orders")
public class DeleteOrderController {

    @Autowired
    private DeleteOrderService deleteOrderService;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDTO handle(@PathVariable Long id) {

        return deleteOrderService.execute(id);
    }
}
