package br.com.venzel.store.modules.payment.use_cases.create_payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.venzel.store.modules.payment.dtos.CreatePaymentDTO;
import br.com.venzel.store.modules.payment.dtos.PaymentDTO;

@RestController
@RequestMapping("/payments")
public class CreatePaymentController {

    @Autowired
    private CreatePaymentService createPaymentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentDTO handle(@RequestBody CreatePaymentDTO dto) {

        return createPaymentService.execute(dto);
    }
}
