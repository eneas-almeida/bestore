package br.com.venzel.store.modules.payment.use_cases.delete_payment;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.payment.dtos.PaymentDTO;
import br.com.venzel.store.modules.payment.entities.Payment;
import br.com.venzel.store.modules.payment.exceptions.PaymentNotFoundException;
import br.com.venzel.store.modules.payment.mappers.PaymentMapper;
import br.com.venzel.store.modules.payment.repositories.PaymentRepository;
import br.com.venzel.store.modules.payment.utils.PaymentMessageUtils;

@Service
public class DeletePaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentMapper paymentMapper;

    @Transactional
    public PaymentDTO execute(Long id) {
        
        Optional<Payment> optionalEntity = paymentRepository.findById(id);

        if (!optionalEntity.isPresent()) {
            throw new PaymentNotFoundException(PaymentMessageUtils.PAYMENT_NOT_FOUND);
        }

        paymentRepository.deleteById(id);

        return paymentMapper.toDTO(optionalEntity.get());
    }
}
