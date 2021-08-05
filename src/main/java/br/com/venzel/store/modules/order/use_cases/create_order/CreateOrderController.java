package br.com.venzel.store.modules.order.use_cases.create_order;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.venzel.store.modules.order.dtos.order.CreateOrderDTO;
import br.com.venzel.store.modules.order.dtos.order.OrderDTO;

@RestController
@RequestMapping("/orders")
public class CreateOrderController {

    @Autowired
    private CreateOrderService createOrderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  ResponseEntity<Void> handle(@RequestBody CreateOrderDTO dto) {

        OrderDTO orderDTO = createOrderService.execute(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(orderDTO.getId())
                        .toUri();
                        
        return ResponseEntity.created(uri).build();
    }
}
