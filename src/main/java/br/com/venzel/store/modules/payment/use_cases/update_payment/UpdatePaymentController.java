package br.com.venzel.store.modules.payment.use_cases.update_payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.venzel.store.modules.payment.dtos.PaymentDTO;
import br.com.venzel.store.modules.payment.dtos.UpdatePaymentDTO;

@RestController
@RequestMapping("/payments")
public class UpdatePaymentController {
    
    @Autowired
    private UpdatePaymentService updatePaymentService;

    @PutMapping("/{id}")
    public PaymentDTO handle(@RequestBody UpdatePaymentDTO dto, @PathVariable Long id) {

        return updatePaymentService.execute(dto, id);
    }
}
