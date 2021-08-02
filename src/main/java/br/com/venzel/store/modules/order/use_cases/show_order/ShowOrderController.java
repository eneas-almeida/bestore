package br.com.venzel.store.modules.order.use_cases.show_order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.venzel.store.modules.order.dtos.order.OrderDTO;

@RestController
@RequestMapping("/orders")
public class ShowOrderController {
    
    @Autowired
    private ShowOrderService showOrderService;
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDTO handle(@PathVariable Long id) {

        return showOrderService.execute(id);
    }
}
