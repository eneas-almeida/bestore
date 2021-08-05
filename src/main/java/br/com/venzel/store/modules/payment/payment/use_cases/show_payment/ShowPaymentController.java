package br.com.venzel.store.modules.payment.payment.use_cases.show_payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.venzel.store.modules.payment.payment.dtos.PaymentDTO;

@RestController
@RequestMapping("/payments")
public class ShowPaymentController {

    @Autowired
    private ShowPaymentService showPaymentService;
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PaymentDTO handle(@PathVariable Long id) {

        return showPaymentService.execute(id);
    }
}
