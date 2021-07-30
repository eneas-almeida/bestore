package br.com.venzel.store.modules.order.use_cases.update_order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.venzel.store.modules.order.dtos.OrderDTO;

@RestController
@RequestMapping("/orders")
public class UpdateOrderController {

    @Autowired
    private UpdateOrderService updateOrderService;

    @PutMapping("/{id}")
    public OrderDTO handle(@RequestBody OrderDTO dto, @PathVariable Long id) {

        return updateOrderService.execute(dto, id);
    }
}
