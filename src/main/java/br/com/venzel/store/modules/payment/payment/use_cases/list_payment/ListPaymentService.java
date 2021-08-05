package br.com.venzel.store.modules.payment.payment.use_cases.list_payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.payment.payment.dtos.PaymentDTO;
import br.com.venzel.store.modules.payment.payment.entities.Payment;
import br.com.venzel.store.modules.payment.payment.exceptions.PaymentNotFoundException;
import br.com.venzel.store.modules.payment.payment.mappers.PaymentMapper;
import br.com.venzel.store.modules.payment.payment.repositories.PaymentRepository;
import br.com.venzel.store.modules.payment.payment.utils.PaymentMessageUtils;

@Service
public class ListPaymentService {
   
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentMapper paymentMapper;

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Page<PaymentDTO> execute(Integer page, Integer linesPerPage, String orderBy, String direction) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

        Page<Payment> payments = paymentRepository.findAll(pageRequest);

        if (payments.isEmpty()) {
            throw new PaymentNotFoundException(PaymentMessageUtils.PAYMENT_NOT_FOUND);
        }

        Page<PaymentDTO> pagePaymentDTO = paymentMapper.toCollectionPageModel(payments);

        return pagePaymentDTO;
    }
}
