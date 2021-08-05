package br.com.venzel.store.modules.order.order.use_cases.list_order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.venzel.store.modules.order.order.dtos.OrderDTO;

@RestController
@RequestMapping("/orders")
public class ListOrderController {
    
    @Autowired
    private ListOrderService listOrderService;

    @GetMapping
    public Page<OrderDTO> handle(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                @RequestParam(value = "linesPerPage", defaultValue = "4") Integer linesPerPage,
                                @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
                                @RequestParam(value = "direction", defaultValue = "ASC") String direction) {

        return listOrderService.execute(page, linesPerPage, orderBy, direction);
    }
}
