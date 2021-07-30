package br.com.venzel.store.modules.payment.use_cases.list_payment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.venzel.store.modules.payment.dtos.PaymentDTO;

@RestController
@RequestMapping("/payments")
public class ListPaymentController {
    
    @Autowired
    private ListPaymentService listPaymentService;

    @GetMapping
    public List<PaymentDTO> handle() {
        return this.listPaymentService.execute();
    }
}
