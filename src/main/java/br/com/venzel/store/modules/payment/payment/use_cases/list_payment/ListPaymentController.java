package br.com.venzel.store.modules.payment.payment.use_cases.list_payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.venzel.store.modules.payment.payment.dtos.PaymentDTO;

@RestController
@RequestMapping("/payments")
public class ListPaymentController {
    
    @Autowired
    private ListPaymentService listPaymentService;

    @GetMapping
    public Page<PaymentDTO> handle(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                    @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                                    @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
                                    @RequestParam(value = "direction", defaultValue = "ASC") String direction) {

        return listPaymentService.execute(page, linesPerPage, orderBy, direction);
    }
}
