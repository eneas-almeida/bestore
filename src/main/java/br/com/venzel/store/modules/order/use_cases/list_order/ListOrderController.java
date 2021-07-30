package br.com.venzel.store.modules.order.use_cases.list_order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.venzel.store.modules.order.dtos.OrderDTO;

@RestController
@RequestMapping("/orders")
public class ListOrderController {
    
    @Autowired
    private ListOrderService listOrderService;

    @GetMapping
    public List<OrderDTO> handle() {
        return this.listOrderService.execute();
    }
}
