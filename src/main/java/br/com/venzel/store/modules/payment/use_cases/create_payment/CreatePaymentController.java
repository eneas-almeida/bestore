package br.com.venzel.store.modules.payment.use_cases.create_payment;

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

import br.com.venzel.store.modules.payment.dtos.CreatePaymentDTO;
import br.com.venzel.store.modules.payment.dtos.PaymentDTO;

@RestController
@RequestMapping("/payments")
public class CreatePaymentController {

    @Autowired
    private CreatePaymentService createPaymentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> handle(@RequestBody CreatePaymentDTO dto) {

        PaymentDTO paymentDTO = createPaymentService.execute(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(paymentDTO.getId())
                        .toUri();
                        
        return ResponseEntity.created(uri).build();
    }
}
